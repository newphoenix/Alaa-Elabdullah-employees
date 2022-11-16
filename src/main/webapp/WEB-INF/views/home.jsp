<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/home.js"></script>
<title>Overlapping working days</title>
</head>
<body>



<div class="container me-0">
<div class="col-12 col-md-10 center mt-4">

<div class="mb-3 mt-2">
		<div id="errorBox" class="alert alert-danger d-none col-xs-10 col-xs-offset-1 col-md-8 col-lg-8 col-lg-offset-1" role="alert">
		   <p id="rmsg"></p>
		</div>
</div>
			
<div class="mb-3">
  <div class="col-xs-10 col-xs-offset-1 col-md-8 col-lg-8 col-lg-offset-1 d-grid">
  <label for="formFileSm" class="form-label">Select CSV file</label>
  <input class="form-control form-control-sm" id="csv" type="file" accept=".csv,.txt">
  </div>
</div>

<div class="mb-3">
			<div class="col-xs-10 col-xs-offset-1 col-md-8 col-lg-8 col-lg-offset-1 d-grid">
				<input id="applyBtn" type="button"
					class="btn btn-primary"
					value="Upload"
					onclick="upload();" />
			</div>
</div>

<div class="col-xs-10 col-xs-offset-1 col-md-8 col-lg-8 col-lg-offset-1 d-grid">
<table id="table" class="table table-striped">

</table>
</div>

</div>
</div>

<script>

</script>

</body>
</html>