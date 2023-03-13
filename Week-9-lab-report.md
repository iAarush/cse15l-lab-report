# Week 9 lab report! 
> Last but not least. 


*Hi, I'm Aarush :) Welcome back to my lab report series!*
In this lab report, I'll be reflecting on my time in CSE 15L and going back to one of my favorite activities from the previous lab reports- doing an in-depth exploration of the `grep` command in my Week 5 lab report (Can you believe that was a month ago? Wow!). 

This week, I'll be looking at a new command and exploring it more deeply. This may be a bit of a cheat- technically, the "command" I'm about to pick is more than a simple command- but it's something that I think will be very useful in my (possible) future web development career, so I wanted to explore it anyway :) 

As you may have guessed from the intro, the command I'll be doing a deep dive into is `vim`. If you, like me, are from the "VS Code generation" (Gen V, perhaps?), it's quite possible you have only heard of- and never used- Vim. 

# An intro to Vim (written in VS Code)
According to <a href="https://www.vim.org">vim.org</a>, Vim is a configurable text editor that comes included with most UNIX systems, included OS X/macOS. The main advantage it has is that it is very efficient for creating and editing text. Typically accessed through the terminal, it's also easy to customize your editor GUI directly with your terminal's UI settings (so I can use a modified version of my homebrew theme, yay!). 

Command line access is a major advantage of Vim- you can use it even if you don't have a GUI set up (although it is important to note that Vim does in fact have a GUI mode), which is helpful for many kinds of servers, including possible applications in a low-budget Raspberry Pi setup or home automation system!

It is technically an extention of "Vi," the default UNIX text editor. However, Vim is more "complete" and if it's also included by default in your OS, why choose Vi over Vim? 

> Fun fact: The Vim faithful are a tightly-knit community and loyal to their Vim keybindings. When Apple brought the second-generation Touch Bar (RIP), which included a physical escape key, Phil Schiller mentioned that professionals using Vim were one of the biggest voices behind the decision to revert to a physical escape key.

# Starting off 
> Well that sounds cool and everything Aarush, but how do you even start to use Vim? 

Good question :) Since Vim is a file editor, it's important to start in a working directory with files to edit! To make sure results are easily reproducible, I'll be running Vim on the `ieng6` server which has served us faithfully throughout CSE 15L. 
<img src="Week-9-lab-report-files/SSH’ing.png">

After SSH'ing into the server, I cloned the Week 3 lab's repository onto the server so that I have a common starting point and have a valid reason to use Vim (edit the bugs that are present in the code!). 
<img src="Week-9-lab-report-files/Image 2.png">

Next, I use the `cd` command to go into the folder containing the files that need to be fixed (if you want to confirm that these files need bugfixes, you can run the tester included in the repository. However, that's outside the scope of this lab report so it hasn't been included). 
<img src="Week-9-lab-report-files/Image 3.png">

Next, I made the terminal window bigger and opened Vim with the following command: 
```bash
vim ArrayExamples.java
```
<img src="Week-9-lab-report-files/Image 4.png">
<img src="Week-9-lab-report-files/Image 5.png">

Et voila, we opened the `ArrayExamples.java` file in Vim! 

# Using Vim 
Now, it's time to learn more about the infamous Vim keybindings! 
<img src="https://imgs.xkcd.com/comics/real_programmers.png">
> And there's a Vim command for that emacs command... (Credit for the comic: XKCD!)

The first thing you'll probably notice the moment Vim opens is that your cursor has disappeared! And of course, your mouse won't do anything in the command line. This is because Vim opens in "normal" mode by default, and the cursor will only appear when you're editing the text file (in this case, `ArrayExamples.java`). 

Chances are, you'll want to open the file editor mode first. To do this, we use the `i` command and enter insert mode (you'll notice your cursor magically appears again). Then, we can use the cursor to make edits (in this case, fixing bugs in the `reverseInPlace` method and `reversed` method). 

Now, let's assume we're done editing the code file and want to save our changes. What do we do? 