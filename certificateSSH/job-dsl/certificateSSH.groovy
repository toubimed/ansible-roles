job('certificateSSH') {
  parameters{
     stringParam('CERTIFICATE_ID', '', 'name that is used to identify the certificate')
     fileParam('my_public_key', 'public user key')
     stringParam('PRINCIPAL_ID', 'root', 'login identities that can be used with that certificate')
     stringParam('VALIDITY', '+1d', 'how long the certificate is valid')
     credentialsParam('ca_private_key') {
            type('org.jenkinsci.plugins.plaincredentials.impl.FileCredentialsImpl')
            defaultValue('ca_private_key')
            required()
            description('certificate private key')
        }
  }
  wrappers {
     credentialsBinding {
            file('CA_CREDENTIAL', 'ca_private_key')
       }
     environmentVariables{
            env('USER_PUBLIC_KEY_PATH', '${WORKSPACE}/id_rsa-${CERTIFICATE_ID}.pub')
            env('CERTIFICATE_SERIAL', '${BUILD_NUMBER}')
     }
   }
  steps {
        shell('''
        mv my_public_key ${WORKSPACE}/id_rsa-${CERTIFICATE_ID}.pub &&
        ssh-keygen -I $CERTIFICATE_ID -s $CA_CREDENTIAL -n $PRINCIPAL_ID -V$VALIDITY -z $CERTIFICATE_SERIAL $USER_PUBLIC_KEY_PATH &&
        echo "*************Certification Details****************************\n" &&
        ssh-keygen -Lf ${WORKSPACE}/id_rsa-${CERTIFICATE_ID}-cert.pub
        ''')
    }
}
