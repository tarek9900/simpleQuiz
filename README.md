# simpleQuiz
Simple quiz is a library that always you to implement a simple yes or no questionnaire

## Demo

![Settings Window](https://media.giphy.com/media/l41K4vyeMccVJ85iw/giphy.gif)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
dependencies {
	        compile 'com.github.tarek9900:simpleQuiz:0.1.0'
	}
```

## Deployment

* You need to create an item card to host your questions you need to add the yes or no buttons as well

```
<lib.tarek.simplequiz.CardButton
                android:id="@+id/cardLayout"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
```

* In your main xml file add the progress seek bar and a view pager to host you item cards 

```
<lib.tarek.simplequiz.CustomProgresseBar
            android:id="@+id/seekBar"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:max="100"
            android:progress="0"
            android:progressDrawable="@android:color/transparent" />
```

* In your Pager adapter implement the QuizAdapter class to set the selected card elevation 
* In your main acitivity java class implement the ButtonInterface to get the true and false click actions

```
@Override public void falseAction() {}
@Override public void trueAction() {}
```
Create a new pager adapter and add your questions
 
```  
QuizPagerAdapter  mCardAdapter = new QuizPagerAdapter();
mCardAdapter.addCardItem(new QuizItem("title" , "Description" , drawbleImage , booleanAnswer));
```
Create ProgressItem for each question to color the seekBar 

```  
mProgressItem = new ProgressItem();
mProgressItem.progressItemPercentage =  100 / mCardAdapter.getCount();
mProgressItem.color = Color.WHITE;
```

## License

```
Copyright (C) 2017 Tarek ben guiza

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
