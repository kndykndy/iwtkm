# CloudFront

## Basics

CF is a CDN for AWS.

**Edge Location** is the location where content will be cached.

ELs:
- not read only -- you can write to it
- objects are cached there the given time in seconds (time-to-live, TTL)
- you can clear cached objects at your EL for a charge

**Distribution** is a collection of Edge Locations.

Distribution types:

- Web distribution for the web sites content
- RTMP for media streaming

**Origin** is the origin of a file CF will distribute. It can be S3, EC2 instance, ELB, Route53,
etc.

When a user requests a file from a nearest Edge Location, if it is not there, it will be downloaded
from the origin to the EL, and cached there.
