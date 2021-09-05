# prevent-invalid-ad-clicks

# Prevent Invalid Ad clicks activities
Prevent invalid Ad clicks in your android app.

Use this library into your project:

# Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

    	allprojects {
		      repositories {
			        ...
			        maven { url 'https://jitpack.io' }
		      }
          }
  
  # Step 2. Add the dependency
 
	dependencies {
	        implementation 'com.github.vijaysoren:prevent-invalid-ad-clicks:1.0.0'
	}
	
	
	

[![](https://jitpack.io/v/vijaysoren/prevent-invalid-ad-clicks.svg)](https://jitpack.io/#vijaysoren/prevent-invalid-ad-clicks)


	




   # Another way to use this library 

    step 1. Clone this project 
    step 2. Include this project into your project as a library 
    step 3. Call methods from the library class "Preventer"

  # How to use methods 
   
   Write your code this way :
 
   1. In your MainActivity (or before initialization of Ad Networks's SDK) -
     
       If(checkIfAdIsBlocked()){

       // if true, do not load SDK

       }else{

       // load SDK

       }
       
       Call method registerOnAdClick() as follows -

       
    Call method in ad events such as
     1. OnAdClick
     2. OnAdIsDisplayed
     3. OnAdIsOpened
     4. OnAdIsClosed
       Etc.
 
  Important: close activity or reload after ad is blocked or close the ad


 # Contribution
    You are welcome to contribute to this project.
    To contribute fork this project.
