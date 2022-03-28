# The Top News

### About the project
This app is intended to load and display top news stories from [**TheNewsAPI**](https://www.thenewsapi.com/). Users have the possibility to see the top stories and check the details in **Webview**.


### Tools Used

The app is build with  **Kotlin** Programming language and  **Android Studio Bumblebee.** It supports from Android Sdk 21.


### Architecture

The app uses **Clean Architecture** to have a unidirectional flow of data, separation of concern, testability, readable and maintainable.
-   Separate layers: Data, Domain and Presentation
-   MVVM architecture for clean separation

### Libraries and tools
The top news app uses below libraries and tools to build efficient application

-   [Kotlin](https://kotlinlang.org/)
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  and  [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)
-   Architecture components (**Navigation, LiveData, ViewModel, Data Binding etc.**)
-   [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)  for dependency injection
-   [Retrofit](https://square.github.io/retrofit/)
-  [Glide](https://github.com/bumptech/glide) for image loading
-  [Timber](https://github.com/JakeWharton/timber) for better logging