# Identity and Access Management, IAM

## Basics

IAM is Global service, you do not specify a region when using it.

IAM manages:

- centralized control of your AWS account
- shared access to your account
- granular permissions
- multi-factor auth
- ability to provide temporary access to users when necessary
- password rotation policy

**User** is an end user, e.g. employees of an org, etc.

**Group** is:

- is a common way to aggregate users
- user in a group inherit all permissions from a group
- e.g. groups: developers, system administrators, HR, etc.

IAM' users and groups are GLOBAL.

**Roles** are assigned to AWS resources, e.g. EC2 instance is not allowed to access S3.

**Policies** provides users, groups and roles with permissions. To set permissions for a group, you
need to apply a JSON-based policy to it.

**Security Group** is a virtual firewall in the cloud.

To use ports you need to explicitly open them.

## Accessing AWS

- visually via AWS Console in a browser
- programmatically via CLI
- programmatically via SDK

Root account is the email address used to create an AWS account. It should not be shared with
anyone. Instead, a user for each individual within an org should be created. Root account must be
protected with 2FA (IAM Dashboard).

## HOW-TOs

### How to log into AWS Console?

- go to and read free tier spec: https://aws.amazon.com/free/
- click Create a Free Account
- go thru a wizard, choose Basic support plan, log in a new acc 

### How to activate MFA?

- go to Services - Security, Identity & Compliance - IAM
- (on IAM Dashboard) click Enable MFA
- click Activate MFA, select Virtual MFA Device
- generate QR code
- install Google Authenticator on a mobile phone, open it, scan QR
- generate MFA code 1, wait 30s and generate another MFA code 2, enter them, click Assign MFA

### How to create a user?

- Options column: Users, then Add User
- fill basics, check if user is allowed to user SDK+CLI and Console, go Next
- click Create Group, name it Admins, assign AWS' AdministratorAccess policy to it
- add tags, optionally, go to summary, click Create User
- YOU SEE THIS PAGE ONLY ONCE: Access key ID, Security access key, Password (to log in the AWS
  console), either download a .csv file or click Send email
- Options column: Account Settings
- click Set password policy (for all users in our account)
