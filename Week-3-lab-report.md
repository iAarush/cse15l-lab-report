# Aarush's Week 3 Lab Report 
*Hi, I'm Aarush! In this lab report, I'll be covering some new topics!*

# Part 1: Building a StringServer! 
In this section of the report, I'm to share the code I used to build a server that processes strings, and explain key parts of it. 
## Imports
```java
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
```
The imports are fairly straightforward- just some libraries that will make our work easier.

```java
public class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler2());
    }
}
```
The main method, shown above, provides some basic code. We interpret the command line arguments to be the port number the user starting the server prefers, and then start a new server at that port on the computer's local network. 

Things get more fun next: 
```java
class Handler2 implements URLHandler {
    ArrayList<String> stored = new ArrayList<String>();
    String appendObject = new String();

    @Override
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return ("null path, try again with a different URL");
        } else if (url.getPath().equals("/add-message")) {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    this.appendObject += parameters[1] + "\n";
                    return String.format(this.appendObject);
                }
            }
            return "null string";
        } else {
            System.out.println("Path: " + url.getPath());
            return "404 Not Found!";
        }
    }
}
```
> Full disclosure: The majority of this code has been repurposed from code I had already written for a lab. 


In the `handler2` method shown above, we pass in the URL the server receives and process it. Outputs that aren't formatted the way we want are rejected, but we accept anything that includes the `"/add-message"`path and the query `s` that follows it. For strings passed to the server in a URL with this format, we concatenate a new line and then add them to an existing array before passing the string representation of the array back to the user! 
> Pretty cool. 

Here are some images of our server in action: 
<img src='Week-3-lab-report-files/First adding-2.png'></img>
>If you're curious about the change in browsers from Safari to Edge, it looks like Chromium-based browsers support this server's output better than Webkit-based browsers.


In the first screenshot, only 1 string is returned because that's the only thing stored in the array right now. At this point, the server has already been started, so only the `Handler2` class is called. The url changes with each request, and this updates the `url.getPath()` method's return value. If the path is the way we want it to be, the `parameters` array will get different values based on the URL that was sent to the server, and this will affect the variable we add to the array. Consequently, it also affects the values returned back to the user. 

This is true for all values that we may pass to the server. The next image shows what the output looks like after `Another test` is passed to the server: 
<img src='Week-3-lab-report-files/Second Adding-2.png'></img>
>Cool beans.

# Part 2: 👾 Bug-fixing 👾
For this section of the report, I'll be talking about a bug I found in Week 3's `reverseInPlace()` method. Originally, this is what the method looked like: 
```java
// Changes the input array to be in reversed order
static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
    arr[i] = arr[arr.length - i - 1];
    }
}
```
As you can see, the method above aimed to reverse the elements of the input array `arr` without creating a new array. Unfortunately, there was a clear bug- visible both by reading through the method and by running a JUnit test with the following input array: 
```java
Int[] input2 = {3, 5, 6, 7};
``` 
<img src='Week-3-lab-report-files/Failed test!.png'>
Reading the error message, it looks like the error appears on the second element of the array– so clearly, the issue isn't something about the actual copying of elements. It looks like there's a logic error in the code instead. Reading the code again, the error becomes clear: after the halfway point, the code simply copies the previously-copied element back to its original spot. 
> In effect, it's replacing only the first half of the array! 

It therefore follows that there are many other possible failure-inducing inputs. An input that doesn't induce failure would be an array with length 1, since the logic error only applies for arrays with length `n>1`. For example, the following array would be fine: 
```java
Int[] input2 = {3};
``` 

The success of this array can be seen in lines 7 and 8 of the right-hand pane in the screenshot above. 


To solve the logic error, we can make a change that will take slightly more memory, but cut runtime in half. *Fixing code? And making it faster in the process? Maybe Southwest Airlines should hire me :P*

By creating a temporary variable to store the original array element before replacing it with the reversed-equivalent on the opposite side, we don't "lose" the original element after the first step of the reversing process is complete. Because we still have the original element, we can use the same logic to place the overwritten element in the second half of the array. By doing twice the work in one iteration, we can also cut the loop time by half. For an array with an odd number of values in it, the middle element wouldn't change position when reversed anyway so we don't need to add any special code for that.

What does this look like in code? Let's take a look. 
<br>
Before: (Note: This is indeed the same code block seen at the start of the page)
```java
  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```
After: 
```java
  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    int temp;
    for(int i = 0; i < arr.length/2; i += 1) {
      temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length-i-1] = temp;
    }
  }
```

<img src='Week-3-lab-report-files/Fixed!.png'></img>
> Passing all tests! <sub>(That is, until the CSE staff start hiding test cases...)</sub>

As you can see from the right-hand pane, the corrected code is passing all test cases including the 2 inputs we considered above. 

# Part 3: Reflecting on new learnings! 
My work in the past 2 labs has given me a lot of practice in things I already knew, and gave me many new things to write notes and think about!
> During the week 3 lab, I definitely felt uncomfortable


Week 2 was interesting to me because I have extensive web development experience, but most of my full-stack experience comes from the Django (Python) framework and so looking at the URI class in Java and working more closely with server-side code (as opposed to mostly importing Django classes and using tools that were already built-in) was really interesting. It was nice to have a bit of a challenge without feeling out of my depth! It was also really interesting to learn more about network ports on computers and being able to run multiple servers on the networked computers- something I hadn't done before! 
<br>
During the week 3 lab, I definitely felt uncomfortable! I've never purposely fished for bugs, and it was weird running Windows commands on a Mac! Nonetheless, it was a good experience and I think I need to reflect on why I didn't want to purposely test for bugs or explore code in this way! 
