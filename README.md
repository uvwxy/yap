# Yet Another Poller
A test repo to learn how the Quartz Scheduler and Ehcache work.

### Running

```
mvn clean package
```

and run the package on Wildfly.

Then `wget "http://localhost:8080/yap/api/v1/startPoller?ip=127.0.0.1&ooid=1.2.1" `.

### TODO
- SNMP Polling
- Caching of results using Ehcache
