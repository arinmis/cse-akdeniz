import os
import sqlite3
from dotenv import load_dotenv
from textblob import TextBlob


def connect_db():
    load_dotenv()
    return sqlite3.connect(os.getenv('DB_NAME'))

def fetch_most_upvoted_posts():
    conn = connect_db()
    c = conn.cursor()
    c.execute("SELECT title, score FROM RedditSubmissions ORDER BY score DESC LIMIT 10")
    results = c.fetchall()
    conn.close()
    return results

def fetch_most_active_authors():
    conn = connect_db()
    c = conn.cursor()
    c.execute("SELECT author_username, COUNT(*) as post_count FROM RedditSubmissions GROUP BY author_username ORDER BY post_count DESC LIMIT 10")
    results = c.fetchall()
    conn.close()
    return results

def perform_sentiment_analysis():
    conn = connect_db()
    c = conn.cursor()
    c.execute("SELECT selftext FROM RedditSubmissions")  # Assuming there's a Comments table
    comments = c.fetchall()
    sentiments = {'positive': 0, 'neutral': 0, 'negative': 0}
    for comment in comments:
        analysis = TextBlob(comment[0])
        if analysis.sentiment.polarity > 0:
            sentiments['positive'] += 1
        elif analysis.sentiment.polarity == 0:
            sentiments['neutral'] += 1
        else:
            sentiments['negative'] += 1
    conn.close()
    return sentiments

# Example usage
print("Most Upvoted Posts:")
for post in fetch_most_upvoted_posts():
    print(post)

print("\nMost Active Authors:")
for author in fetch_most_active_authors():
    print(author)

print("\nSentiment Analysis of Comments:")
print(perform_sentiment_analysis())
