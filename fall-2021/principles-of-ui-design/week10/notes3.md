### Event Queue
- Events are stored in a queue
- Mouse moves are coalesced into a signle event in queue
- Mouse coalicing makes drawing quality bad

### Event Loop
- While application is running:
    * Get event from queue
    * Translate raw event into higher-level events
- High-level GUI toolkits do events loop internally

### Event Dispatch & Propagation
- Dispatch: choose target componentfor event 
- Propagation: event bubbles up hirarchy
- Consumption: event stops propagating
