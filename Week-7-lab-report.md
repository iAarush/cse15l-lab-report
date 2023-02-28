# New week, new lab report! #CLDQ

In our most recent CSE 15L lab, we did something really interesting- a timed competition using command-line tools. Even though I don't have too much experience with the command line (I prefer beautiful GUIs, but I concede that CLIs are faster and required in some situations). As a result, the competition was a good mix of fun and learning new things. 

Although I did not have times that measured in seconds, I was able to enjoy significant improvements, going from 11 minutes 15 seconds to the low single digit minutes! Below, I've shared the steps I had to take along with the commands I used to get there, along with any improvements I would like to try out next time. 

# Step 1: SSHing 
<img src="Week-7-lab-report-files/Step 1.png">

> Credit for this excellent wallpaper goes to BasicAppleGuy.

In this step, I entered the following commands: 
```bash
ssh cs15lwi23aap@ieng6.ucsd.edu
`password`
```
With the code above, I used SSH to connect to the remote `ieng6` server. My username was shared in the first line, while my password (not shown for obvious reasons) was entered in the second line. 

A faster method would be to set up and use an SSH key. Unfortunately, due to time constraints during my lab, I was not able to set this up. SSH keys are an excellent solution in this case, allowing you to connect to the `ieng6` server faster without sacrificing security. 

# Step 2: Cloning my fork 
<img src="Week-7-lab-report-files/Step 2.png">
The next thing I did was to clone my fork of the Lab7 repository from Github to the server using the command line. 

```bash 
git clone https://github.com/iAarush/lab7.git
```

The effect of this line was to use the `git` library to `clone` the repository existing at `https://github.com/iAarush/lab7.git` into my working directory, commonly referred to as the `pwd`. After this command runs, I have a local copy of all the files in the repository.

> It's important to note that any changes made locally will not automatically sync with the files on the specified URL. We will have to manually sync local changes with the online version in a process that will be explored in a few steps. 

# Step 3: Running the tests 
Next, I wanted to run the JUnit tests provided in the repository to check if the code is working as intended. The first step is to set up the JUnit classpaths, since the JUnit libraries were included with the repository. 

```bash 
cd lab7 #I find it easiest to `cd` into the folder we just downloaded 
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ListExamplesTests
```

<img src="Week-7-lab-report-files/Step 3.png">
As indicated by the output, the tests show 1 failure in the file. But how did I get here in the first place? In the first line, I changed my current working directory into the repository, because it feels more natural to me. 

> If aiming for speed, this is probably not the best decision, however. 

Then, I used the next 2 lines to add the JUnit classpaths, compile all the Java files, and then run the `ListExamplesTests` file. This produced the output shown in the image above. 

During the lab, I later found out that its faster to stack these commands into 1 line by separating them with a semicolon. 

# Step 4: Editing the code 
To edit the code, I decided to use `vim` because I knew it and we had covered this in a previous lecture. I used the following command to open up the `vim` interface within my command-line window. 

```bash
vim Listexamples.java
```

<img src="Week-7-lab-report-files/vim.png">

Reading through the code in the window that opened up, I noticed a logic error in the third `while` loop: The wrong variable was being incremented! This would lead to a runtime error while running the code, and eventually lead to a timeout (or possibly a memory leak, or both!). Not ideal. 

To fix this, I used the `i` key  on my keyboard to enter `vim`'s "insert" mode which allows you to edit the open file. After making the required change, I pressed the `esc` key on my computer (with a short moment of silence because I'm in the minority that misses the Touch Bar and virtual escape key) to exit the insertion mode in vim. From here, I used the `:x` (important: Don't use a capital X!) to close the vim editor and save my changes. 

<img src="Week-7-lab-report-files/after vim changes.png">

Hopefully, the code passes the tests now. We're about to find out... 

# Step 5: Running the tests again
This step was easier because we were just repeating the JUnit tests and this was something that was already in the command line's history. A neat trick in the command line is that the `<up>` arrow key can be used to load the previous command. In my case, I was able to press `<up>` 5 times to compile all the Java files again, and then 5 times again to run the tester. 

<img src="Week-7-lab-report-files/Step 5.png">
Based on the output displayed, it's now clear that the changes I made were sufficient to fix the previous bugs. 

> All systems go! 

# Step 6: Commit and push 
The last step is to update my (useful) changes back to my online Github repository so that I can access it from all my devices. If this was a shared repository, it would also enable all other collaborators on the repository to access my changes. 

By default, git doesn't know which files to be looking for and which ones not to. For simplicity, I choose to add all files to git for now. 

```bash 
git add *
git status 
git commit -m "Fixed logic error" #Note that the commit message, represented by the string after the -m modifier, is both good practice and also required for a commit. 
git push 
`git username`
`git password` #Note that you must generate a personal access token if you have 2FA on. 
```

<img src="Week-7-lab-report-files/Step 6.png">

What does all of this code mean? How did it work? 
In the first line of code, I told `git` to "add" all the files in the `pwd`. To simplify, `git` added a listener that checks for changes to the binaries of the specified files. (Yes, this means you can use Git to create backups of your computer). In the next line, I had `git` display it's "status" to make sure it had added the correct files and that it detected the changes I had made to the main Java file. This isn't strictly needed for speed, but it's a good practice for general software development and a habit for me at this point. 

Next, I told `git` to save (commit) all the changes at this point (similar to a checkpoint in video games) and used `-m` to add a message that would allow me to easily identify what this commit represented. 

Finally, with the change committed to my local `git`, I used `git push` to "push" my changes onto the cloud. 

Due to time constraints, I wasn't able to set up an SSH key for `git` either. As a result, the next 2 commands involved me adding my Git username and password so that the commit could be authenticated and added to my personal Github account's repository. 

And that's it! At first, this took me some time (more than 11 minutes) but with practice, I was able to reduce it by around 90%- a significant improvement! 