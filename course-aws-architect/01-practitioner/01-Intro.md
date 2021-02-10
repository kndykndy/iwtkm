# AWS Certified Cloud Practitioner

## 6 advantages of cloud

1. Trade capital expense for variable expense  
   Instead of buying a server upfront you can pay for a time of its computation.
2. Benefit from massive economies of scale  
   No need to compete with Amazon trying to build better infrastructure.
3. Stop guessing about capacity  
   Use autoscaling to align with line of your demand.
4. Increase speed and agility  
   Build and deploy full-fledged working solutions in weeks instead of months.
5. Stop spending money running and maintaining own data centers  
   It is cheaper to pay for computing infrastructure built by AWS rather than building own one.
6. Go global in minutes  
   You can deploy your solution to data centers across all continents in minutes.

## 3 types of cloud computing

1. IaaS, e.g. EC2
2. PaaS, e.g. Elastic BeansTalk
3. SaaS, e.g. Gmail

## Region/Availability zone/Edge location

**Region** - physical location in the world, consisting of 2+ AZs.
**Availability zone** - 1+ discrete data centers, with redundant power, network and connectivity,
house in separate facilities.
**Edge location** - endpoints for AWS used for caching contents. Typically, it consists of
CloudFront, Amazon's CDN.

How to choose right AWS Region?

- data sovereignty laws - e.g. regulations of where a data should reside
- latency to end users - do not provision your cloud in Tokyo if most of your customers are in US
- services availability - e.g. Glacier was not available in Singapore, MSK in Frankfurt

## AWS client support packages

- basic - free
- developer - 29USD/month, scales based on usage
- business - 100USD/month, scales based on usage
- enterprise - 15K USD, a dedicated Technical Account Manager is assigned

## Billing

**Billing Alerts/Alarms** will warn you automatically when a given level of AWS spend is reached, so
you won't pay money without realising it.

## Identity & Access Management - IAM

It is Global service, you do not specify a region when using it. IAM users and groups are GLOBAL.

## Accessing AWS

- visually via AWS Console in browser
- programmatically via CLI
- programmatically via SDK

## Access rules

Root account is the email address used to create an AWS account. It should not be shared with
anyone. Instead, a user for each individual within an org should be created. Root account must be
protected with 2FA.
