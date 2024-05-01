import os
from dotenv import load_dotenv
import sqlite3

load_dotenv()
conn = sqlite3.connect(os.getenv('DB_NAME'))

# Create table
conn.execute('''
    CREATE TABLE IF NOT EXISTS RedditSubmissions (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        author_username TEXT,
        created_utc INTEGER,
        is_self BOOLEAN,
        link_flair_text TEXT,
        num_comments INTEGER,
        permalink TEXT,
        score INTEGER,
        selftext TEXT,
        subreddit TEXT,
        title TEXT,
        upvote_ratio REAL,
        url TEXT
    )
''')

conn.close()

