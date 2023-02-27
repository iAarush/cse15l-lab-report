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

An interesting quirk about the `grep` command is that it prints out context before and after the found pattern, which might be useful in seeing a sentence or 2 around the text. The `-A` modifier, according to my good friend (<sup>don't judge me</sup>) ChatGPT, stands for "after-context," and this allows us to modify how much "context" (lines before or after the found pattern) we get after the pattern. 
<img src="Week-5-lab-report-files/macGPT 1.png">

In the image below, I run `grep -A 2 "Lucayans" -r` and `grep -A 10 "Lucayans" -r` and the difference in the size of the output is striking. (ignore the -r for now)

<img src="Week-5-lab-report-files/grep -A (x2).png">
It just goes to show how useful this command must be in situations where you only want a sentence's worth of context, or perhaps need a full paragraph. 

<br>The `-B` modifier works in the same way, but modifies the context *before* the found pattern. Here are examples of the same 2 commands, but with the `-B` modifier instead of `-A`: 

<img src="Week-5-lab-report-files/grep -B.png">

> Cool! 

# The `-C` modifier 
Now you can probably imagine that in most cases where we need to modify both the before and after contexts, we will probably be modifying them by the same number. Obviously, it's inefficient to have to type the same number and pass it into 2 arguments. This is where the `-C` modifier comes in. As you might have guessed, it just stands for plain "context" and is the equivalent of modifying both the before and after contexts together. 

The image below shows what the output looks like for `grep -C 2 "Lucayans" -r` and `grep -C 10 "Lucayans" -r`, in that order. 

<img src='Week-5-lab-report-files/grep -C.png'>

> You can see just how much "context" 10 lines before and after the string are! 

# And finally, `-r`
Finally, let's take a look at the `-r` modifier that I've been passing into all the previous commands! 

It's important to understand the general anatomy of a `grep` command before we see the value of `-r`. A simple `grep` command would take the form: 
```bash 
grep [pattern] [files to search]
```
The `-A`, `-B`, and `-C` modifiers we had been passing in earlier all went before the pattern, but `-r` actually goes after the pattern. The reason for this is that `-r` stands for "recursive," and modifies `grep`'s behavior to recursively search every file in the directory instead of searching only a specified pattern. If you need to search every file in a directory with variable folder structures, this can be a really useful command!

> That's it for today! I hope you had fun, learned something new, and enjoyed reading this! 

Adios 🫡.

# Research Notes
Because I used ChatGPT for some of my research in this lab report, I have provided my prompts and the outputs below. 
<img src="Week-5-lab-report-files/chatGPT/chatGPT 1.png">
<img src="Week-5-lab-report-files/chatGPT/chatGPT 2.png">
<img src="Week-5-lab-report-files/chatGPT/chatGPT 3.png">