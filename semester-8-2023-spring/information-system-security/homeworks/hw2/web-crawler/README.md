# Getting Started

Create virtiual environment, install dependencies and activate virtiual environment.

```
python -m venv venv
source venv/bin/active
pip install -r requirments.txt
```


## Configure Credentials and Reddit topic
Create `.env` file in the root of the repository and fill following credentials and 

```
CLIENT_ID=<client-id>
CLIENT_SECRET=<client-secret>
PASSWORD=<password>
USER_AGENT=<user-agent>
USERNAME=<user-name>
DB_NAME=<sqlite-db-name.db>
SUBREDDIT_TOPIC=<topic>
SUBREDDIT_LIMIT=<limit>
```

**Note:** Do not share your credentials publicly.


## Create DB
`python migrate.py`

## Scap the data

Simply run `python scrap_reddit.py`

## Scap the data

Simply run `python scrap_reddit.py`

## See stats
`python analayze.py`
