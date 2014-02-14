java_rest_api_client
====================

A sample Java client for communicating with the UltraDNS REST API

Dependencies
============

Gradle is used to build the code.  The Gradle Wrapper is included with the build for users who do not already have gradle installed.  All other dependent libraries will be downloaded when the project is built.

If you want to build and test the code:

./gradlew clean check test -Drest.username=USERNAME -Drest.password=PASSWORD -Drest.url=https://restapi.ultradns.com

Replace USERNAME and PASSWORD with your own username and password.

Functionality
=============

The sample code does not attempt to implement a client for all available UltraDNS REST API functionality.  It provides access to basic functionality.  Adding additional functionality should be relatively straightforward, and any contributions from the UltraDNS community would be greatly appreciated.  See the unit test at biz.neustar.ultra.rest.client.RestApiClientTest for an example of how to use this library in your own code.

Questions
=========

Please contact UltraDNS support if you have any questions or encounter any issues with this code.

