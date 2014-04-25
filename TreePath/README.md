README Tree Path

/bin : has Main.class - start point for the application
/bin/tree : Node.class - Node implemetation
            path.class - This is path generator , creates list of combination paths from the user input path
            Tree.class - This has the Tree algorithms implemented to insert,collapse,find synonym tree
       <br />
          
/src : Source Code for .java extension for the above files 

How to Run:

Compile the code and then 

java Main<br />
Enter the Path                     //perform insertion any ways burst mode or one by one <br />
1: Give Path to insert            //if node already present doesn't create duplicate  <br />
2: Collapse                       //if give path is not present it create from where the mismatch is<br />
3: Subtree Detection<br />
4: Exit<br />
Enter Option by the number given<br />
1<br />
Enter Path<br />
/sopley<br />
scopley<br />
<br />
Enter the Path<br />            
1: Give Path to insert<br />
2: Collapse<br />
3: Subtree Detection<br />
4: Exit<br />
Enter Option by the number given<br />
1<br />
Enter path<br />

/scopley/ab|cd/ef|gh                        //insertion using "|" expression<br />
<br />
scopley<br />	
cd	ab	ab-cd<br />	
gh	ef	ef-gh	gh	ef	ef-gh	gh	ef	ef-gh<br />	

1: Give Path to insert<br />
2: Collapse                //Perform collapse operation<br />
3: Subtree Detection<br />
4: Exit<br />
Enter Option by the number given<br />
2<br />
/scopley/ab|cd/ef|gh<br />


Enter the Path<br />
1: Give Path to insert<br />
2: Collapse<br />
3: Subtree Detection<br />
4: Exit<br />
Enter Option by the number given<br />
1<br />
Enter path<br />
/scopley/ab-cd/zz<br />
<br />
scopley<br />     
cd	ab	ab-cd<br />       
gh	ef	ef-gh	gh	ef	ef-gh	gh	ef	ef-gh	zz              //zz added under /scopley/ab-cd<br />
<br />
<br />
Enter the Path<br />
1: Give Path to insert<br />
2: Collapse<br />
3: Subtree Detection<br />                                     //subtree, print synonyms
4: Exit<br />
Enter Option by the number given<br />
3<br />
Enter path<br />
/scopley/ab<br />
[/scopley/cd, /scopley/ab]          ///because these two have same child nodes ie ef|gh , /scopley/ab-cd missed out<br />                                          ///because it has zz under which makes it different<br />



