# Data Control and Privacy

Analytics Cloud provides different administrative tools for managing individual data and privacy. To access the tools, click &rarr; *Settings* &rarr; *Data Control & Privacy*.

![Different tools are found in the data control and privacy section of settings.](./data-control-and-privacy/images/01.png)

## Retention Period

By default, event data and inactive anonymous individuals are retained for 13 months. To change the retention period from 13 months to 7 months,

1. Use the drop-down menu to select 7 months.

    ![A pop-up window will give a warning when changing period.](./data-control-and-privacy/images/02.png)

1. A warning window will pop-up to confirm your change.

1. Click *Change Period *to save.

```Warning
You will permanently lose analytics data that has been recorded over 7 months ago when you make this change.
```

## Request Log

Manage and control collected data of individuals with this tool. New requests can be made to access individual data, delete individual data, or suppress individual data. For example, an individual may contact you requesting data collected on them to be shared or to be deleted.

To create a new request or view previous requests, click the *Manage* button.

![Create a new request or view previous requests.](./data-control-and-privacy/images/03.png)

A log of previous requests is presented. Use the filter function or search function to find a particular request. To download a ZIP file of a request, click the *Download* button of the request. 

To create a new request,

1. Click the *Create Request* button.

    ![A new window opens to create a new request.](./data-control-and-privacy/images/04.png)

1. Select the Job Type. Selecting Access creates a downloadable file of all data collected related to the individual. Selecting Delete removes all Personally Identifiable Information (PII) of an individual and places them on the suppressed list. Selecting Suppress stops further data collection of the individual.

1. Input an email for the new request. A list of emails in a CSV file can also be uploaded.

1. Click *Save* and the request will be processed. 

A log of previous requests can be downloaded by clicking on the *Export Log* button on the main page.

![Click the Export Log button to download a log of previous requests.](./data-control-and-privacy/images/05.png)

Select a start date and an end date and click the *Download* button for a CSV log file.

## Suppressed Users

Suppressing a user stops further data collection of an individual. To view a list of suppressed individuals or to unsuppress an individual, click the *Manage* button.

![View suppressed individuals or unsuppress individuals.](./data-control-and-privacy/images/06.png)

Search the list of suppressed individuals by inputting a particular email address. 

To unsuppress, locate the individual and click the *Unsuppress* button.

A list of suppressed individuals can be downloaded by clicking on the *Export List* button on the main page.

![Click the Export List button to download a list of suppressed individuals.](./data-control-and-privacy/images/07.png)

Select a start date and an end date and click the *Download* button for a CSV list file.

## Do Not Track Feature

According to GDPR and many data privacy laws, businesses are required to ask consent before collecting analytics data when visitors are browsing a website.

To suppress analytics data from being sent by a particular browser, set the following window variable with javascript on your site.

```
window['ac_client_disable_tracking'] = true
```

```important::
   You must implement your own logic to persist user consent either by using a cookie or by saving and loading from your database. Please make sure that the window variable described above is set before the client page is fully loaded.
```

Visitors to your site can also choose to enable do not track from their browser. Learn more about the [do not track setting in browsers](https://allaboutdnt.com/). With this enabled no data is sent or collected by Analytics Cloud. 