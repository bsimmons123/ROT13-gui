<!DOCTYPE html>
<html lang="en">
<head>
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <meta charset="UTF-8">
  <title>PLD-gui</title>
</head>
<body>
  <!-- header -->
  <div>
    <div style="text-align: center;">
      <h1>PLD-gui</h1>
    </div>
  </div>

  <div style="text-align: center;" class="body-pos">
    <div>
      <form action="${pageContext.request.contextPath}/cypher.start" method = "POST">
        <input type="text" id="Name" name="input-value">
        <input class="btn btn-success" type="Submit" name="login" value="Cypher!">
      </form>
      <p>${hashedValues}</p> <!-- This represents the output of hashed values -->
    </div>
  </div>
</body>
<style>
  body {
    background-image: url("images/background.png");
    background-repeat: no-repeat;
    background-size: cover;
  }
</style>
</html>