# Event logging system

_Simple application made for leaning Spring Core basics._

### Events

Loggers work with following event types:

* INFO
* ERROR

### Loggers

Provided loggers:

* __ConsoleEventLogger__ logs events directly to console.
* __FileEventLogger__ logs events directly to file.
* __CacheFileEventLogger__ logs events firstly to cache. When cache is filled out the logger writes data from cache to file.
* __CombinedFileEventLogger__ logs events both to file and console.

### Configuration

Default configuration provides the following options:

* logging __INFO__ events to console
* logging __ERROR__ events to both console and file during day period and only to file during night time
* logging events both to cache and file
