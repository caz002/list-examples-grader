# Create your grading script here
echo 'Grading...'
CPATH='.:../lib/hamcrest-core-1.3.jar:/lib/junit-4.13.2.jar'
rm -rf student-submission
git clone $1 student-submission
cd student-submission
if [[ -e ListExamples.java ]]
then
    echo 'ListExamples.java was found! +1 points'
else
    echo 'ListExamples.java is missing +0 points'
    echo 'You scored 0/3 on this assignment'
    exit 1
fi
cd ..
cp TestListExamples.java ./student-submission
cd student-submission
javac -cp $CPATH *.java 2> output-error.txt
if [[ ! -s output-error.txt ]]
then
        echo 'Compile succeeded! + 1 point'
else
        echo 'Your program did not compile. +0 points'
        echo 'You scored 1/3 on this assignment'
        exit 1
fi
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > testOutput.txt
echo $?
if grep -Fxq "FAIL" testOutput.txt
then
    echo 'Code failed the tests. +0 points'
    echo 'You scored 2/3 on this assignment'
    exit 1
else
    echo 'Code passed all the tests. +1 point'
fi
echo 'You scored 3/3 on this assignment. Congrats!'
exit 0