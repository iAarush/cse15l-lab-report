# Aarush's Week 1 Lab Report 
*Hi, I'm Aarush! In this tutorial, I'll help you log in to a 
course-specific account on **ieng6**, a remote server for UCSD students.*
<br>


**NOTE:**
>This tutorial is written for macOS and assumes you are on Ventura (13). Steps may not work on older macOS versions or other operating systems.
<br>

# Starting off
It's important that you have a course-specific account for CSE 15L set up before you begin. Without this, you won't be able to use SSH (short for **Secure SHell**) to log on to the server. 
> <a href='https://sdacs.ucsd.edu/~icc/index.php'>Click here to create or reset your password</a>

You can also use the link above to look up your username and check your account's permissions. After you reset your password, it may take 15 minutes to update and reflect on the server. 
# Step 1: Installing VS Code
Visual Studio Code, commonly referred to as VS Code or VSC, is one of the most popular text editors used today. You can use the link below to download VS Code for your device: 
> https://code.visualstudio.com/

After it's installed and set up, it should look similar to this when you first open it: 
<img src='Screenshot 2023-01-11 at 12.15.48 PM.png'>
Then, navigate to the terminal menu and select the button to create a new terminal: 
<img src='Creating a terminal.png'>

After clicking on this button, a terminal will appear on the bottom half of your screen. If it's too small, it may be a good idea to resize it and make it bigger! 
<br>
It's time for the next step!

# Step 2: SSHing
SSH is a protocol that allows someone to connect to another computer (in this case, a remote server) through the command line. It's useful because it allows you to use your personal machine to access files, run code, or do other activities on a machine that you aren't able to physically use. 
<br>
We'll be using SSH to enter a machine in the School of Engineering's lab on the `ieng6` server. 

> By convention, commands begin with a `$`. However, these should not be copied into the terminal!

The first step is to enter the command `ssh` followed by your course-specific account `@` ieng6.ucsd.edu. Almost like an email address! 
> `$ ssh myusername@ieng6.ucsd.edu`

If successful, you'll get a message like the one below the first time you connect to the server: 
> The authenticity of host 'ieng6.ucsd.edu (128.54.70.227)' can't be established.
RSA key fingerprint is `SHA256:ksruYwhnYH+sySHnHAtLUHngrPEyZTDl/1x99wUQcec`.
Are you sure you want to continue connecting (yes/no/[fingerprint])?

There's no security threat to saying yes if it's the first time you're connecting to this server, but it could be a cause for concern if a message like this pops up on a server you have connected to in the past. After you say yes, you'll probably have to enter your password. 
<br>
Once you're done with that, you'll be connected to the remote server! The update message should look like this: 
<img src='Server-2.png'>
And you're in! Now, the commands you run from the terminal will be processed remotely on the server, and not on your computer. You don't even need to be physically present at the Engineering department's lab to make use of the remote server! 
> Pretty neat.
# Step 3: Running commands remotely 
At the moment, there isn't much on the remote server in the way of files, programs, or other things. However, I've included some screenshots of commands that I ran on the server and what the output looked like. A brief caption of each command and what it does is also provided. 
<img src='ls -a.png'>
The command `ls -a` lists all files, including hidden ones (which begin with a `.` in this case). 
<img src='ls -lat.png'>
This is an interesting one! We continue to use the `ls` command to list files, but use 3 modifiers this time. `l` gives a list of all files, `a` shows hidden files as well in the list, and `t` lists files in the order they were last modified in (most recent first). Other modifiers to `ls` include `F`, `R`, and `r`. 
<img src='cd perl5.png'>
Next, I navigate to the pre-existing `perl5` folder and repeat the `ls -lat` command to list all files in this directory. However, it's empty right now. 
<img src='cd ~.png'>
Finally, I used the `~` shortcut to navigate back to the server's home directory. 
# Step 4: Signing out
Finally, to sign out of the SSH session, we can use an exit command and then quit the terminal. 
> `$ exit`

That's it for today! 