Role Name
=========

ansible role to setting up a Kubernetes cluster that will consist of one master and two worker nodes. All the nodes will run Ubuntu Xenial 64-bit OS and Ansible playbooks will be used for provisioning

Requirements
------------

- Vagrant should be installed on your machine.
- Oracle VirtualBox can be used as a Vagrant provider or make use of similar providers as      described in Vagrant's official
- Ansible should be installed in your machine.

Role Variables
--------------

A description of the settable variables for this role should go here, including any variables that are in defaults/main.yml, vars/main.yml, and any variables that can/should be set via parameters to the role. Any variables that are read from other roles and/or the global scope (ie. hostvars, group vars, etc.) should be mentioned here as well.

Dependencies
------------

A list of other roles hosted on Galaxy should go here, plus any details in regards to parameters that may need to be set for other roles, or variables that are used from other roles.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: servers
      roles:
         - { role: username.rolename, x: 42 }

License
-------

BSD

Author Information
------------------

An optional section for the role authors to include contact information, or a website (HTML is not allowed).
