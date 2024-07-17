# Automated Code Generation and Test GE

All Rights Reserved

# Introduction

The purpose of this project is to understand the use of automated code generation to develop an application. In this report, we explain how we used ChatGPT (generative pre-trained transformer), a programming model that can generate code for the development of Learning Management System (LMS) for the specific needs of Flinders university. Key features in LMS are user authentication, access to course materials, assignment submissions, online examinations and communication discussion forums.

Prompt Engineering:

Prompt engineering is the process where you ask/guide GenAI (Generative Artificial Intelligence) by using natural language text to generate desired solutions or outputs for your prompts. In simple terms, it is where you are asking AI machine understandably and clearly to generate your desired output. It requires detailed instructions to create high-quality and relevant output. So that an application's generative AI works as intended. ChatGPT is one of such AI models that is pre-trained with large sets of data to answer our prompts.

# 1\. List of Prompts used to generate the code

Note: we are not copy/pasting all the prompt text which we used in ChatGPT to this document as it will increase word count we are only including the text that is necessary to get an overview of our prompting methodology and technique. We also ignored prompts that are duplicates such as removing errors in specific lines to reduce unnecessary text flow. For example, refer to prompt 1 to get an understanding.

Initially, we started ChatGPT by giving the data, such as our LMS application requirements (paragraph given by the client) So that AI Model can understand what our client's exact requirements are and what the product is intended to do. We asked ChatGPT to outline all the client's requirements in points

**Prompt-1:**

We have a project where an application needs to be built using Java in IntelliJ Below, I will provide you with the details of Client requirements: (In here we have pasted the LMS paragraph given by lecturer)

In the above prompt, we asked ChatGPT to outline requirements to get precise requirement details of a client without missing any part. And after we asked gpt below

**Prompt\-2:**

Now based on the given requirements can you enhance these requirements to get a better application with robust feature for a client.

The above prompt allows us to use chatgpt in a better way to develop a robust application with enhanced features so that we can exceed client expectations. By above prompt chatgpt gave us enhanced features which we put to work.

**Prompt\-3:**

Now based on all the given requirements, I want you to generate code that satisfies all the requirements where I will test this code in IntelliJ.

The above prompt generated multiple sets of code with test classes and main method files. We then created relevant files and tested in Intellij to verify Whether it satisfies the requirements. after further review of these, we asked chatgpt whether to integrate all these files or not

**Prompt\-4:**

Is it Beneficial to connect all the codes that you have generated according to the LMS Specification requirement? give me a generalized overview of whether to do this or not?

The above prompt allowed us to understand whether to connect all the requirements. Based on chatGPT output, we found it beneficial to interlink all the code sets. then we used the following prompt:

**Prompt\-5:**

Connect all the components (Course, Student, User, User Manager, Academic and LMS) into a single system

This allowed ChatGPT to create a robust code within a single system however multiple test modules.

**Prompt\-6:**

When the combined code is tested in IntelliJ, I am receiving errors on lines 11, 12 and 31. fix these issues and generate corrected code.

when we tested code in intelli J, we understood that there are errors in generated code as well we then made above prompt make chatgpt to remove any errors in specific lines and generate accurate code. after multiple prompts and different errors that were corrected, we were able to get the correct code still with many updates and changes required and to be tested.

**Prompt\-7:**

"Comment the code which you generated to get an overview and explain the code in comments according to relevant sections"

This prompt allowed us to understand the generated code by commenting.

From this below section we started going into the specifics of the code, where we prompted GPT to explain the individual sections of the code on how to verify and test these functionalities.

**Prompt-8:**

"Explain How Logout and Login work. Also explain how-to re-log in when logged out due to inactivity"

**Prompt-9:**

"Students can access course materials, upload assignments, take online exams, and check grades. how can I verify and test these functionalities in Intelli J ?"

**Prompt-10:**

“How can I verify and test the course materials, upload assignments, take online exams, and check grades and all relevant functionalities in Intelli J?”

**Prompt-11:**

“Press 'r' to reset inactivity timer, 'q' to logout, 'a' to access materials, 'u' to upload assignment, 'e' to take exam, 'g' to check grades: a when I press a, u, e, and g it says invalid output”

In the above prompt I have prompted gpt to rectify issues for the specific scenario where I am receiving invalid output

**Prompt-12:**

"Can you explain how to refactor the main Java file of a Learning Management System (LMS) to create unit test cases? Please include steps for identifying testable methods, writing test cases using JUnit, and organizing the test code for better readability and maintenance"

To understand about lms unit test cases, we have used above prompt.

**Prompt-13:**

write 20 test cases for lms (important one) and 5 negative test cases and explain every test case

The above prompt is used to generate test cases both positive and negative. but chatgpt only generated positive test cases, so then I have to specifically ask it to generate negative test cases as well

**Prompt-14:**

The test cases which you generated are only Positive test-cases 20. Generate the remaining five negative test cases as well.

**Prompt-15:**

“I am encountering errors in the methods dropCourse, removeCourse, and getCourse. Do I need to modify the Course.java file to resolve these issues? Please advise on what changes might be necessary.”

These are the primary prompts we used to generate successful working code that satisfies our client Flinder's University requirements. We have used multiple prompts in between these prompts to develop a working code by rectifying the errors. we have not included all these prompts as those are unnecessary and can make this document wordy.

# _User Manag_er Test

This section focuses on test scenarios related to user management functionalities such as adding users, login, logout, inactivity timer handling, resetting inactivity timer, and handling both student and academic user actions.

| **Test Case ID** | **Description** | **Input Value** | **Steps to Perform** | **Expected Output** | **Actual Output** | **Outcome** | **Coverage** | **Test Type** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| UM01 | Add User | Student<br><br>("student2", "password2") | Add a new student user and verify it can be logged in. | User should be able to log in successfully. | User logged in successfully. | Pass | User Manager | Functional |
| UM02 | Login User | student1,<br><br>"password1" | Log in with correct credentials and verify. | User should be logged in successfully. | User logged in successfully. | Pass | User Manager | Functional |
| UM03 | Logout User | student1,<br><br>"password1" | Log in and then log out, verify user is logged out. | User should be logged out successfully. | User logged out successfully. | Fail | User Manager | Functional |
| UM04 | Start Inactivity Timer | student1,<br><br>"password1" | Log in, start inactivity timer, wait for timeout. | Logging out due to inactivity. and user should be null. | Logging out due to inactivity. and user is null. | Pass | User Manager | Functional |
| UM05 | Stop Inactivity Timer | student1,<br><br>"password1" | Log in, start and stop inactivity timer, verify user remains logged in. | User should remain logged in. | User remains logged in. | Pass | User Manager | Functional |
| UM06 | Reset Inactivity Timer | student1,<br><br>"password1" | Log in, reset inactivity timer, verify user remains logged in. | User should remain logged in. | User remains logged in. | Pass | User Manager | Functional |
| UM07 | Run Method with Student | student1\\<br><br>npassword1\\nq\\n | Run the User Manager, input student credentials and logout. | User should log in as student and then log out. | User logged in as student and then logged out. | Pass | User Manager | Functional |
| UM08 | Run Method with Academic | academic1\\<br><br>npassword2\\nq\\n | Run the User Manager, input academic credentials and logout. | User should log in as academic and then log out. | User logged in as academic and then logged out. | Fail | User Manager | Functional |
| UM09 | Handle Student Actions | COMP101\\n | Log in as student, try accessing materials for an unregistered course. | You are not enrolled in COMP101 | You are not enrolled in COMP101 | Fail | User Manager | Functional |
| UM10 | Handle Academic Actions | COMP101\\<br><br>nLecture notes\\n | Log in as academic, try uploading content for an unregistered course. | Course not found: COMP101 | Course not found: COMP101 | Pass | User Manager | Functional |
| UM11 | Get Current User | student1,<br><br>"password1" | Log in, get current user, then log out. | Should return current user when logged in and null when logged out. | Returns current user when logged in and null when logged out. | Pass | User Manager | Functional |
| UM12 | Invalid Login | invalidUser, "password" | Attempt to log in with invalid credentials. | Should not log in and current user should be null. | Did not log in and current user is null. | Pass | User Manager | Boundary |
| UM13 | Duplicate User Addition | Student<br><br>("student1", "password1") | Add a user with duplicate username, check user count. | No duplicate user added, user count should be 2. | No duplicate user added, user count is 2. | Pass | User Manager | Functional |
| UM14 | Inactivity Timer without Login | N/A | Start inactivity timer without logging in, wait for timeout. | Should not log out due to inactivity and no message should appear. | No logout message and no user logged in. | Pass | User Manager | Boundary |
| UM15 | Handle Invalid User Role | User("unknown", "password", "unknown") | Add and log in with a user with an invalid role, perform some action. | Invalid input or operation not allowed for the current user. | Invalid input or operation not allowed for the current user. | Pass | User Manager | Boundary |
| UM16 | Reset Inactivity Timer Action | student1,<br><br>"password1" | Log in as student, input "r" to reset inactivity timer. | Inactivity timer reset. | Inactivity timer reset. | Pass | User Manager | Functional |
| UM17 | Handle Academic Actions - Course Not Found | academic1, "password2", "PHYS101<br><br>\\nLecture notes\\n" | Log in as academic, input "up" for an unregistered course. | Course not found: PHYS101 | Course not found: PHYS101 | Pass | User Manager | Functional |
| UM18 | Handle Invalid Input for Student | student1, "password1", "invalid\\n" | Log in as student, input an invalid action. | Invalid input or operation not allowed for the current user. | Invalid input or operation not allowed for the current user. | Pass | User Manager | Boundary |
| UM19 | Handle Invalid Input for Academic | academic1, "password2", "invalid\\n" | Log in as academic, input an invalid action. | Invalid input or operation not allowed for the current user. | Invalid input or operation not allowed for the current user. | Pass | User Manager | Boundary |
| UM20 | Logging Out Due to Inactivity | student1,<br><br>"password1" | Log in, start inactivity timer, wait for timeout. | Logging out due to inactivity. and user should be null. | Test buffered and failed. | Fail | User Manager | Functional |
| UM21 | Handle Academic Actions - Course Not Found for Post | academic1, "password2", "PHYS101<br><br>\\nDiscussion post\\n" | Log in as academic, input "p" for an unregistered course. | Course not found: PHYS101 | Course not found: PHYS101 | Pass | User Manager | Functional |

Academic tests:

_Academic:_ This table covers test cases related to academic functionalities such as adding courses, retrieving courses, uploading content, posting in discussion forums, and removing courses.

| **Test Case ID** | **Description** | **Input Value** | **Steps to Perform** | **Expected Output** | **Actual Output** | **Outcome** | **Coverage** | **Test Type** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| A01 | Add Course | Course("PHYS101") | Add a new course and verify it exists. | Course should be added successfully. | Course added successfully. | Pass | Academic | Functional |
| A02 | Get Course | COMP101 | Verify getting an existing course. | Should return the correct course. | Returned the correct course. | Pass | Academic | Functional |
| A03 | Upload Content | COMP101, "Lecture notes for week 1" | Upload content to an existing course, verify it exists. | Content should be uploaded successfully. | Content uploaded successfully. | Pass | Academic | Functional |
| A04 | Post In Discussion Forum | COMP101, "What did you think of the lecture?" | Post in the discussion forum for an existing course, verify it exists. | Post should be added successfully. | Post added successfully. | Pass | Academic | Functional |
| A05 | Remove Course | COMP101 | Remove an existing course, verify it no longer exists. | Course should be removed successfully. | Course removed successfully. | Pass | Academic | Functional |
| A06 | Get Courses | N/A | Verify getting all courses for the academic. | Should return all courses. | Returned all courses. | Pass | Academic | Functional |
| A07 | Add Duplicate Course | Course("COMP101") | Add a duplicate course, verify no duplicate exists. | Should not add duplicate and should show a message. | Did not add duplicate and showed message. | Fail | Academic | Boundary |
| A08 | Remove Non-Existent Course | PHYS101 | Remove a non-existent course, verify error message. | Course not found: PHYS101 | Course not found: PHYS101 | Fail | Academic | Boundary |

## Course Test

This below table focuses on test cases related to course functionalities including getting course names, adding materials, uploading assignments, adding exams, adding grades, retrieving calendar events, and adding discussion posts.  

| **Test Case ID** | **Description** | **Input Value** | **Steps to Perform** | **Expected Output** | **Actual Output** | **Outcome** | **Coverage** | **Test Type** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| C01 | Get Course Name | N/A | Verify getting the course name. | Should return the correct course name. | Returned the correct course name. | Pass | Course | Functional |
| C02 | Add Material | Lecture notes for week 1 | Add material to the course, verify it exists. | Material should be added successfully. | Material added successfully. | Pass | Course | Functional |
| C03 | Upload Assignment | Assignment 1 | Upload an assignment, verify it exists. | Assignment should be uploaded successfully. | Assignment uploaded successfully. | Pass | Course | Functional |
| C05 | Add Exam | Midterm Exam | Add an exam, verify it exists. | Exam should be added successfully. | Exam added successfully. | Pass | Course | Functional |
| C06 | Add Grade | A+  | Add a grade, verify it exists. | Grade should be added successfully. | Grade added successfully. | Pass | Course | Functional |
| C07 | Calendar Events | N/A | Verify getting all calendar events. | Should return all calendar events. | Returned all calendar events. | Pass | Course | Functional |
| C08 | Add Discussion Post | What did you think of the lecture? | Add a discussion post, verify it exists. | Discussion post should be added successfully. | Discussion post added successfully. | Pass | Course | Functional |
| C09 | Add Null Material | null | Add null material, verify it is not added. | Null material should not be added. | Null material not added. | Fail | Course | Boundary |
| C10 | Upload Null Assignment | null | Upload null assignment, verify it is not added. | Null assignment should not be added. | Null assignment not added. | Fail | Course | Boundary |

##

Student Test:

This table focuses on test cases related to student functionalities such as enrolling in courses, dropping courses, accessing materials, uploading assignments, taking exams, checking grades, viewing the academic calendar, and handling null courses.

| **Test Case ID** | **Description** | **Input Value** | **Steps to Perform** | **Expected Output** | **Actual Output** | **Outcome** | **Coverage** | **Test Type** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| S01 | Enroll in Course | MATH101 | Enroll in a new course, verify enrollment. | Should enroll in the course successfully. | Enrolled in the course successfully. | Pass | Student | Functional |
| S02 | Drop Course | COMP101 | Drop an existing course, verify it is removed. | Should drop the course successfully. | Dropped the course successfully. | Pass | Student | Functional |
| S03 | Get Course | COMP101 | Verify getting an enrolled course. | Should return the correct course. | Returned the correct course. | Pass | Student | Functional |
| S04 | Access Materials | COMP101 | Access materials for an enrolled course, verify they exist. | Should access the materials successfully. | Accessed the materials successfully. | Pass | Student | Functional |
| S05 | Upload Assignment | COMP101, "Assignment 1" | Upload assignment for an enrolled course, verify it is uploaded. | Assignment should be uploaded successfully. | Assignment uploaded successfully. | Pass | Student | Functional |
| S06 | Take Exam | COMP101, "Midterm Exam" | Take an exam for an enrolled course, verify it is taken. | Exam should be taken successfully. | Exam taken successfully. | Pass | Student | Functional |
| S07 | Check Grades | COMP101 | Check grades for an enrolled course, verify they exist. | Should check the grades successfully. | Checked the grades successfully. | Pass | Student | Functional |
| S08 | View Academic Calendar | COMP101 | View academic calendar for an enrolled course, verify events exist. | Should view the academic calendar successfully. | Viewed the academic calendar successfully. | Pass | Student | Functional |
| S09 | Get Enrolled Courses | N/A | Verify getting all enrolled courses. | Should return all enrolled courses. | Returned all enrolled courses. | Pass | Student | Functional |
| S10 | Access Materials for Null Course | null | Access materials for a null course, verify error message. | You are not enrolled in null | You are not enrolled in null | Pass | Student | Boundary |
| S11 | Upload Assignment for Null Course | null, "Assignment 1" | Upload assignment for a null course, verify error message. | You are not enrolled in null | You are not enrolled in null | Pass | Student | Boundary |

##

User Test:

This table focuses on test cases related to user functionalities including retrieving usernames, passwords, roles, authenticating users, enrolling in courses, and adding courses for academic staff.

| **Test Case ID** | **Description** | **Input Value** | **Steps to Perform** | **Expected Output** | **Actual Output** | **Outcome** | **Coverage** | **Test Type** |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| U01 | Get Username | N/A | Verify getting the username. | Should return the correct username. | Returned the correct username. | Pass | User | Functional |
| U02 | Get Password | N/A | Verify getting the password. | Should return the correct password. | Returned the correct password. | Pass | User | Functional |
| U03 | Get Role | N/A | Verify getting the role. | Should return the correct role. | Returned the correct role. | Pass | User | Functional |
| U04 | Authenticate | student1,<br><br>"pass1" | Authenticate with correct credentials. | Should authenticate successfully. | Authenticated successfully. | Pass | User | Functional |
| U05 | Authenticate With Empty Credentials | , "" | Authenticate with empty credentials. | Should not authenticate. | Did not authenticate. | Pass | User | Boundary |
| U06 | Authenticate With Null Credentials | null, null | Authenticate with null credentials. | Should not authenticate. | Did not authenticate. | Pass | User | Boundary |
| U07 | Enroll in Course | Course<br><br>("COMP101") | Enroll as a student in a course, verify enrollment. | Should enroll in the course successfully. | Enrolled in the course successfully. | Pass | User | Functional |
| U08 | Add Course | Course<br><br>("COMP101") | Add a course as an academic, verify addition. | Should add the course successfully. | Added the course successfully. | Pass | User | Functional |
| U09 | Get Course | COMP101 | Verify getting an enrolled course. | Should return the correct course. | Returned the correct course. | Pass | User | Functional |
| U10 | Get Courses | N/A | Verify getting all courses. | Should return all courses. | Returned all courses. | Pass | User | Functional |
| U11 | Enroll in Course as Academic | Course<br><br>("COMP101") | Enroll in a course as an academic, verify it is not allowed. | Only students can enroll in courses. | Only students can enroll in courses. | Pass | User | Functional |
| U12 | Add Course as Student | Course<br><br>("COMP101") | Add a course as a student, verify it is not allowed. | Only academic staff can add courses. | Only academic staff can add courses. | Pass | User | Functional |

## Failed Test cases  

| test Case ID | Name of the Test Failed | Why It Failed | Recommendations |
| --- | --- | --- | --- |
| UM03 | Logout User | The logout method mayt not clear the CurrentUser variable or stop the timer before the method is executed. | Check that the logoutUser method is correctly setting the currentUser value to null which also stops the idle timer. |
| UM08 | Run Method with Academic | The run method may have issues handling the academic user's input and logout process. | Check the input handling logic for the academic users correctly processes the logout command and changes in state. |
| UM09 | Handle Student Actions | There may be an issue with how student actions are handled for unregistered courses. | Make sure that proper validation and error messages are showing when user is check materials for a un registered course |
| UM20 | Logging Out Due to Inactivity | The idle timer could not be correctly triggering the logout process. | Verify the inactivity timer's settings and check it calls logout User correctly after the specified timeout. |
| A07 | Add Duplicate Course | The method might not be correctly checking and also stopping duplicate courses. | run and verify logic to check for existing courses before adding a new one. also showing appropriate messages. |
| A08 | Remove Non-Existent Course | The method might not be correctly checkine non-existent courses or showing appropriate messages. | Make sure the method checks if the course exists before trying to remove it and displays correct messages. |
| C09 | Add Null Material | The method might not be handling null input properly, leading to unexpected behaviour. | Implement null checks before adding materials to check null values are not added. |
| C10 | Upload Null Assignment | The method might not be handling null input properly, to unexpected behavior. | initiate null checks before uploading assignments to make sure null values are not added |

<br/><br/>in figures 3 and 4 we can see the lines that are not covered in coverage lines are 41, 42, and 172.  
The conditional actions which are the lines with the inactivity timer as well as the “Course not found” message do not seem to be covered due to the absence of relevant test conditions to properly define the definition of the desired scenarios as improper. Also, other timing problems that are part of the life cycle of a program could exist; for instance, the inactivity timer, would not be tested adequately. Third, some assessment areas could be repeated or combined with other areas of learning and as such, they may not be the focus of the lines thus not effectively covering these lines.  
<br/>

# Recommendations

Based on our precise prompts, The code generated by ChatGPT for the LMS shows basic functionalities for the requirements such as user authentication, course management, material uploads, and discussion forums. The Ai model can do decent work but without developer interference, the model may not exceed the client’s expectations even with precise and detailed prompts as it requires development. However, it is important to know it reduces the amount of work the developer handles regularly by generating code that doesn’t require creativity but requires automation for specific classes or functions. By analyzing clients’ requirements, Organisations can use ChatGPT to do automated tasks such as catching basic syntax errors, and complexity issues, and compliance with coding standards. But as mentioned before these may not exceed the expectations but can significantly reduce workload for organisations so that developers can focus on critical sections to show their creativity and get a better outcome.

The code contains unnecessary boilerplate that requires manual modifications, such as multiple unused methods in user profile management. This redundancy increases the complexity and reduces the maintainability of the system. Removing redundant code can improve the codebase which makes the code easier to read and maintain. Also, the error handling in the generated code does not cover all scenarios, like file type mismatches during uploads. Making error handles cover all edge cases and scenarios will improve the system’s reliability.

Even if ChatGPT is given precise prompts it fails to follow proper security measures The code follows default security practices which are insecure and not good for an LMS. For example, it stores passwords using old hashing algorithms. using the latest security practices, like using strong hashing algorithms and compliance with secure coding standards, is important for protecting user data. The use of data structures like "HashMap" for data storage will lead to scalability issues as the no.of users and courses increases. The code is overly complex for users to understand, it contains nested loops and conditions, which makes it difficult to understand and maintain. Simplifying the logic and structure will improve readability.

**Reflections:**

ChatGPT is useful for catching basic syntax errors, and complexity issues, but these tools may not be effective in important areas. They mainly focus on surface-level metrics and won’t go into depth even if we prompt them to do so, such as finding out unnecessary I/O operations or the absence of caching strategies. Automated tools lack the background of the topic and fail to understand the necessary areas to determine the proper use of data structures and the specific performance needs of different application components. They also cannot fully capture runtime behavior or effectively handle real-world data loads.

By prompting in detail ChatGPT will help to build the basic structure of different classes, but it will lead to issues like logical errors, improper variable formats, and unclear structure. So completely depending on prompt engineering/ChatGPT without developer overseeing is not wise. Human involvement is important to review and customise the generated code, resolve its limitations, and make sure that it meets Industry standards.
