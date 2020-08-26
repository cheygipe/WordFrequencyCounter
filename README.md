# Word-Frequency-Counter
Algorithm that reads a text file (.txt) and counts the frequency of words in the given text.

## How to run this project?:
1. First make sure to have installed the latest Java version. After this make sure to have Intellij IDE installed, this one because I made the project using Intellij but if you have or like Eclipse IDE, NetBeans or another software that you know to run Java projects is also valid. **You can follow the instructions of installation from this video: https://www.youtube.com/watch?v=EMLTOMdIz4w**
3. Then download the project from the repository and open Intellij, then select File > Open and search for the project folder wherever you saved it and select it. 
4. After you open the project folder, scroll down to the last method **public static void main(String[] args)**, you will see a play icon (*►*) at the left of the method, press it and select the option **Run WordFrequency.main()**.
5. You will see the result displayed in the console. 
OPTIONAL: If you want to test it with any text that you like, just open the file “words.txt”, type any text that you like and save it, then run again the main method as previously explained.



## What is the computational complexity of this code?:
The computational complexity of this program is O(n^2), because we can see that the code has different methods and these methods have different processes with O(1), O(n) and O(n^2) complexity. Taking this into account, the fastest growing term is O(n^2) due to nested loops, meaning that the execution time is quadratic and obviously is bigger than constant O(1) and linear O(n) time.
