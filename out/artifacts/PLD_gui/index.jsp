<!DOCTYPE html>
<html lang="en">
<head>
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <%-- import for AJAX --%>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="js/AJAX.js"></script>
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
        <form>
            <input type="text" id="value_to_hash" name="input_value">
            <input class="btn btn-success begin-cypher" type="Submit" name="begin-cypher" value="Cypher!">
        </form>
        <p id="originalInput"></p> <!-- This represents the output of hashed values -->
        <p id="result"></p> <!-- This represents the output of hashed values -->
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