# Video Streaming

Challenges:

-   Scaleability
-   Heterogeneity

Solution is distributed, application-level infrastructure

## DASH: Dynamic Adaptiv Streaming over HTTP

-   Server:
    -   Divides video file into multiple chunks
    -   each chunk encoded at muylitpl ediffrent reates
    -   different rate encodings stored in fdifferent files
    -   fiels replicated in various CDN nodes
    -   **manifest file** provides URLs for diffrent chunks
-   Client:
    -   preioadically estimates server-to-client bandwidth
    -   consulting manifest, requests one chunk at a time
        -   chooses max coding rate sustainable given current bandwidth
        -   can choose different coding rates at different points in time, and from different servers

Client access data chunks using server addresses which main server send via mainfest file.

-   OOT: "over the top"
