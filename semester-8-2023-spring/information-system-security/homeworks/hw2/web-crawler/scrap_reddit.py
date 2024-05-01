import os
import sqlite3
from dotenv import load_dotenv
import praw
from reddit_submission import RedditSubmission 

# Example of inserting a RedditSubmission
def insert_submission(submission):
    conn = sqlite3.connect(os.getenv('DB_NAME'))
    conn.execute('''
        INSERT INTO RedditSubmissions (author_username, created_utc, is_self, link_flair_text, num_comments, permalink, score, selftext, subreddit, title, upvote_ratio, url)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    ''', (
        submission.author_username,
        submission.created_utc,
        submission.is_self,
        submission.link_flair_text,
        submission.num_comments,
        submission.permalink,
        submission.score,
        submission.selftext,
        submission.subreddit,
        submission.title,
        submission.upvote_ratio,
        submission.url
    ))
    conn.commit()
    conn.close()

def fetch_subreddit(topic):
    subreddit = reddit.subreddit(topic)
    reddit_submissions = []
    try:
        for submission in subreddit.hot(limit=int(os.getenv("SUBREDDIT_LIMIT"))):
            reddit_submissions.append(RedditSubmission(submission))
    except Exception as e:
        print(f"An error occurred: {e}")
    return reddit_submissions

def save_submissions(submissions):
    for s in submissions: 
        print(s.url)
        insert_submission(s)


if __name__ == "__main__":
    # Load environment variables from .env file
    load_dotenv()
    # Initialize PRAW with environment variables
    reddit = praw.Reddit(
        client_id=os.getenv('CLIENT_ID'),
        client_secret=os.getenv('CLIENT_SECRET'),
        user_agent=os.getenv('USER_AGENT'),
    )
    reddit.read_only = True
    submissions = fetch_subreddit(os.getenv("SUBREDDIT_TOPIC"))
    save_submissions(submissions)

