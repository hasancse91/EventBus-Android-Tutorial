# EventBus Android Tutorial

We'll design this type of sample Android App using [EventBus](https://github.com/google/guava/wiki/EventBusExplained) Android Library:

<img src="https://raw.githubusercontent.com/hasancse91/EventBus-Android-Tutorial/master/Data/eventbus-practice-tutorial.gif" width="250" height="444" />

### Prepare Gradle
First of all add these dependencies to your gradle file: 
```xml
dependencies {
    ...
    compile 'org.greenrobot:eventbus:3.0.0'
    ...
   }
```
Here I used version `3.0.0` and it's the latest version (till 5th August, 2017), you should use the latest version.

Using Retrofit network library I send a GET request to recieve some JSON data from server.

```java
public class NetworkCall {
    public static void getData(){
        Logger.addLogAdapter(new AndroidLogAdapter());
        String myUrl = "https://raw.githubusercontent.com/hasancse91/EventBus-Android-Tutorial/master/Data/data.json";

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getDataFromServer(myUrl);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Logger.d("Response: " + response.message());
                EventBus.getDefault().post(new DataReceiveEvent(Config.DATA_RECEIVED, response.message()));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Logger.d("Failure: " + t.toString());
                EventBus.getDefault().post(new DataReceiveEvent(Config.DATA_RECEIVED, t.toString()));
            }
        });
    }
}
```

Inside the network callback methods I post an Event to cahnge update the UI (MainActivity). Now we have subscribe the event from `MainActivity.java` class. Inside the method we can change the Text of `TextView`.

```java
@Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DataReceiveEvent event) throws ClassNotFoundException {
        if (event.isTagMatchWith(Config.DATA_RECEIVED)) {
            textView.setText(event.getResponseMessage());
        }
}
```

And also have to register-unregister EventBus in MainActivity:

```java
@Override
public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
}

@Override
public void onStop() {
    super.onStop();
    EventBus.getDefault().unregister(this);
}
```

To get the whole project please clone it and run at your machine. If you see any error please let me know or send pull request.

Thank you. :-)

