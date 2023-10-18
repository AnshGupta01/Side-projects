// index.js
// where your node app starts

// init project
var express = require("express");
var app = express();

// enable CORS (https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
// so that your API is remotely testable by FCC
var cors = require("cors");
app.use(cors({ optionsSuccessStatus: 200 })); // some legacy browsers choke on 204

// http://expressjs.com/en/starter/static-files.html
app.use(express.static("public"));

// http://expressjs.com/en/starter/basic-routing.html
app.get("/", function (req, res) {
  res.sendFile(__dirname + "/views/index.html");
});

// your first API endpoint...
app.get("/api/hello", function (req, res) {
  res.json({ greeting: "hello API" });
});

var listener = app.listen(3000, function () {
  console.log("Your app is listening on port " + listener.address().port);
});

app.get("/api/:date?", (request, response) => {
  let date = request.params.date;
  let unixDate;
  let utcDate;
  let dateObject;

  let isUnix = /^\d+$/.test(date);

  if(!date) {
    dateObject = new Date();
  }
  else if (isUnix && date) {
    unixDate = parseInt(date);
    dateObject = new Date(unixDate);
  } 
  else if (!isUnix && date) {
    dateObject = new Date(date);
  }


  if (dateObject.toString() === "Invalid Date") {
    response.json({
      error: "Invalid Date",
    });
    return;
  }

  unixDate = dateObject.getTime();
  utcDate = dateObject.toUTCString();

  response.json({
    unix: unixDate,
    utc: utcDate,
  });
});