# -*- mode: ruby -*-
# vi: set ft=ruby :

# Specify minimum Vagrant version and Vagrant API version
Vagrant.require_version ">= 1.6.0"
VAGRANTFILE_API_VERSION = "2"

# Require YAML module
require 'yaml'

# Read YAML file with box details
servers = YAML.load_file('servers.yaml')

# Create boxes
Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

 #ensure that all Vagrant machine use the same key ssh
  config.ssh.insert_key = false

  # Iterate through entries in YAML file
  servers.each do |servers|
    config.vm.define servers["name"] do |srv|
    config.vm.hostname = servers["hostname"]
      srv.vm.box = servers["box_name"]
      srv.vm.network "public_network", ip: servers["ip"], bridge: servers["bridge_interface"]
      srv.vm.provider :virtualbox do |vb|
        vb.name = servers["name"]
        vb.gui = servers["gui"]
        vb.memory = servers["ram"]
        vb.cpus = servers["cpus"]
      end
     srv.vm.provision "ansible" do |ansible|
      ansible.playbook = servers["playbook_path"]
      ansible.become = true
     end
    end
  end
end
