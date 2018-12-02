# SpringBootMVC
Project skeleton for Software Project class in the University of Iceland.

## How do I run this ?
This project is setup using [Maven](https://maven.apache.org/what-is-maven.html) as a dependency manager, so if your IDE does not manage that, or you don't have it installed you can look [here](https://maven.apache.org/install.html) for further information.
When all the dependencies are downloaded, you can run the project by running the ``main()`` method in the class ``Application`` and then enter [localhost:8080](http://localhost:8080) into the address bar of your favorite web browser.

You also need to set up postgresql to be able to run this program. After installing postgresql run the following commands on a mac terminal:
CREATE USER admin WITH PASSWORD 'admin';
CREATE DATABASE hbv;
GRANT ALL PRIVILEGES ON DATABASE hbv TO admin;