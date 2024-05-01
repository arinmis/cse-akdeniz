class RedditSubmission:
    """
    A class to store a Reddit submission. It takes a submission object as its constructor parameter.
    """
    def __init__(self, submission):
        self.author_username = submission.author.name
        self.created_utc = submission.created_utc
        self.id = submission.id
        self.is_self = submission.is_self
        self.link_flair_text = submission.link_flair_text
        self.num_comments = submission.num_comments
        self.permalink = submission.permalink
        self.score = submission.score
        self.selftext = submission.selftext
        self.subreddit = str(submission.subreddit)  
        self.title = submission.title
        self.upvote_ratio = submission.upvote_ratio
        self.url = submission.url
    

    @staticmethod
    def header():
        return "author_flair_text,created_utc,id,is_self,link_flair_text,num_comments,permalink,score,selftext,subreddit,title,upvote_ratio,url"

    def __str__(self):
        """
        String method to output the instance variables as a CSV string.
        """
        # Create a list of attributes to be included in the CSV string
        str_attributes = [
            self.author_username,
            str(self.created_utc),
            self.id,
            str(self.is_self),
            self.link_flair_text,
            str(self.num_comments),
            self.permalink,
            str(self.score),
            self.selftext,
            self.subreddit,
            self.title,
            str(self.upvote_ratio),
            self.url
        ]
        str_attributes = [str(x) for x in str_attributes] 
        return ','.join(str_attributes)
