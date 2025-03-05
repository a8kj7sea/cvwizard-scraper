
# CVWizard Scraper

**CVWizard Scraper** is a simple and efficient project that allows you to download an HTML CV and convert it to PDF easily and smoothly—helping you save money.

## Features:
- Download HTML CVs from CVWizard
- Convert the downloaded HTML CV to PDF with ease
- Save money by avoiding paid services

## How It Works:
This project makes it easy to create a free CV on CVWizard without the need for downloads or additional costs.

### Requirements:
- **Java** must be installed on your device to run the file seamlessly.
  
### Usage Instructions:

1. Create your resume on the CVWizard website as shown in the following image.

  <img alt="image" src="https://cdn.discordapp.com/attachments/1337062133606912020/1346805892854710283/image.png?ex=67c9863b&is=67c834bb&hm=6b70a0e46cbf8a3a02eb0ca026fd36d3aa26e3742e965fcaac1325a278168aff&">

3. Then, create your own account on the following website:  
   [https://www.convertapi.com/a/api/html-to-pdf](https://www.convertapi.com/a/api/html-to-pdf)

4. Afterward, go to the "Auth" section and copy the secret key.

5. Finally, execute the following command:

```bash
java -jar cvwizard-scraper.jar <url> <secret-key>
```

Replace `<url>` with the link to your CV and `<secret-key>` with the API key you copied.


**At the end, you will get an output.pdf file, and here is our destination path, as shown in the image**


 <img alt="image" src="https://cdn.discordapp.com/attachments/1337062133606912020/1346806907553320990/image.png?ex=67c9872d&is=67c835ad&hm=aaced88fe91de5307cd84668a56ba04ec280de0464c02a37e05cc53fb556f6ca&">
