# The Domain Name Service: DNS

Internet hosts have IP address(to address datagram) and names.

-   Distrubuted DB

-   Core internet function implemented by application layer to put complexity at network's edge.

-   Functions of DNS:
    1. Hostname-to-IP-address translation
    2. Host liasing
    3. Mail server aliasing
    4. Load distribution

## DNS: a distruted, hierarchical database

```
root                             ROOT
   |__ .com                      TOP LEVEL DOMAIN
   |      |__ amazon.com         AUTHORITATIVE
   |      |__ yahoo.com
   |
   |__ .org
   |      |__ pbs.org
   |
   |__ .edu
          |__ akdeniz.edu
```

-   To get IP of **amazon.com**

    1. query to root find .com DNS server
    2. query to .com to find amazon.com DNS server
    3. query to amazon.com to find www.amazon.com DNS server

### Root

ICANN manages root DNS domain.

### Top Level Domain(TDL)

Responsible for .com, .org, .net .edu etc. and all top-level country domains, eg: .tr, .uk, .jp

### Top Level Domain(TDL)

Responsible for .com, .org, .net .edu etc. and all top-level country domains, eg: .tr, .uk, .jp

### Authoritative

Can be maintained by organiztion or service provider.

#### Local DNS

Local DNS reply first if not found in local forward request to DNS hierarcy for resolution.

## Resolving IP

### Iterative

-   Ask to root, ask to TDL and ask to authoritative DNS
-   Authoritative will return IP

### Recursive

-   Ask to root
-   Root will ask to TDL and authoritative DNS server
-   Root will return IP

#### Caching DNS Information

-   Once server learns mapping, it caches and use this for future reponse.
    -   Cache timeout after some time(TTL)
-   Cache entries may be **out-of-date** if it is updated, and TTLs hasn't expired.

#### DNS records

Resource Records

```
(name, value, type, ttl)
```

Type **A** record: www.foo.com
Type **MX** record: foo.com

#### DNS security

-   DDoS attacks
    -   Bombard root server with traffic
    -   Bombard TLD server with traffic
