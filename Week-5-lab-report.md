# Aarush's Week 5 Lab Report 
Hi, I'm Aarush! In this week's lab report, we'll be doing things a little differently- it's time to do a deep dive into a smaller, more specific topic this week :). 

We'll be considering bash's `grep` command this week, and we'll explore a variety of different ways to use it for the specific thing we want to do! 

# Starting off 
The first thing to know here is that I am generally pretty bad at remembering command-line arguments. So, I always want to know and memorize just one thing- the `-help` command! 
> The `-help` command typically has a slightly different syntax for different packages and contexts. It's useful because it'll list all other possible commands and arugments you can use! (So, you only need to memorize this one command and you'll know how to pull up all other commands, yay!)

`grep` is a GNU tool that "prints lines that contain a match for one or more patterns," per the official GNU Grep 3.8 documentation. It lets you search files in a directory for text that might be contained within them, and it's faster than macOS' Spotlight when set up correctly (a conspiracy theorist might say that Spotlight gets slower every year but people don't notice because processors get faster every year...) But I digress. 

Naturally, then, the first thing I did was open the `grep` documentation to find out what the relevant help command is. As it turns out, is it: 

```bash
$ grep --help
```

<img src="Week-5-lab-report-files/grep —help.png">

> It looks like there are a lot of options to play around with! 

# `-A` and `-B`
> Yes, that's the first time I've used inline code blocks in a heading

I used another interesting command, `man grep` to open the built-in manual. This contains more information for each command as compared to the `--help` command, although the output is much longer in this case. 

<img src="Week-5-lab-report-files/man grep.png">

> Since the `grep` command is used to search for a string inside files, all the commands displayed after this take place within a directory called `written_2` that has been used in my CSE 15L classes for a while now. 

