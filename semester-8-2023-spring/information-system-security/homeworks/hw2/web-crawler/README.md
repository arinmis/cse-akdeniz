# Getting Started

Create virtiual environment, install dependencies and activate virtiual environment.

```
python -m venv venv
source venv/bin/active
pip install -r requirements.txt
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

Results for `wwe` subreddit
```
Most Upvoted Posts:
('Real stats/facts that feel fake?', 2262)
('Gunther didn’t want to join the main roster because of Vince McMahon.', 932)
('Got a photo of Roman Reigns, and his victims framed.', 805)
('WWE knows about the Def Rebel complaints.', 599)
('Bro what the hell is wrong with people it hasn’t even been a month💀', 415)
('Drew McIntyre should go over CM Punk', 381)
('Former WWE Champion returns to Monday Night RAW', 229)
('I hope the Final Testament is going to be drafted to Raw', 184)
('The NXT call ups should be  what the draft is about.   \n', 162)
('What a beautiful shot. Still surreal to know that CM Punk is back in WWE. My God. ', 140)

Most Active Authors:
('Snubie1', 4)
('as14prez', 2)
('zerogtoilet', 1)
('squallLeonhart20', 1)
('shreddedcheese11', 1)
('searcher4421', 1)
('renegade-811', 1)
('murphy788', 1)
('lipsdontdie', 1)
('leftarmorthodox', 1)

Sentiment Analysis of Comments:
{'positive': 33, 'neutral': 12, 'negative': 5}
```
