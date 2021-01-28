# Do Not Track Feature

According to GDPR and many data privacy laws, businesses are required to ask consent before collecting analytics data when visitors are browsing a website.

To suppress analytics data from being sent by a particular browser, set the following window variable with javascript on your site.

```
window['ac_client_disable_tracking'] = true
```

```important::
   You must implement your own logic to persist user consent either by using a cookie or by saving and loading from your database. Please make sure that the window variable described above is set before the client page is fully loaded.
```

Visitors to your site can also choose to enable do not track from their browser. Learn more about the [do not track setting in browsers](https://allaboutdnt.com/). With this enabled no data is sent or collected by Analytics Cloud. 
