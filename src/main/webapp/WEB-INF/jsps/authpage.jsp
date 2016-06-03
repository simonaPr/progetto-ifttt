<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Test</title>
    <style>
        .table th {
            text-align: center;
        }
        .booked {
            background-color: yellow;
        }
    </style>

   
    <script src="/static/js/libs/lodash.js"></script>
    <script src="/static/js/libs/jquery.js"></script>
    <script src="/static/js/libs/jquery-ui.js"></script>

    <script src="/static/js/libs/bootstrap.js"></script>
    <script src="/static/js/libs/moment.js"></script>
    <script src="/static/js/libs/moment-range.js"></script>
    <script src="/static/js/libs/angular.js"></script>
    <script src="/static/js/libs/angular-route.js"></script>


    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/jquery-ui.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/animate.css">

</head>
<body>
${msg}
<nav id="navbar" class="navbar navbar-default" role="navigation" >
    <div class="navbar-header">
        <button type="button" class="navbar-toggle"
                data-toggle="collapse" data-target="#nav-toggle">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">Receipt website</a>
    </div>
    <div class="collapse navbar-collapse" id="nav-toggle">
        <ul class="nav navbar-nav">
            <li><a href="https://www.google.it">Google (example)</a></li>
            <li><a href="https://twitter.com">Twitter (example)</a></li>
        </ul>
        <form class="navbar-form navbar-right" method="POST">
            <input name="username" type="text" class="form-control"
                   placeholder="Username">
            <input name="password" type="password" class="form-control"
                   placeholder="Password">
            <button type="submit" />
        </form>
    </div>
</nav>

<div id="lipsum" class="container fadeIn animated">
    <div class="row">
        <div class="col-sm-12">
            <div class="clearfix">
    <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eu lorem id sapien pretium viverra vitae blandit magna. Ut mattis finibus lectus, quis mollis elit. Morbi tempor, turpis sit amet rutrum accumsan, ipsum elit vehicula dolor, id pulvinar turpis ipsum id justo. Mauris tincidunt bibendum est a luctus. Nam at urna ac ex bibendum facilisis dignissim ac ligula. Morbi tempus urna orci, ac commodo eros molestie nec. Proin nec sagittis dui.
    </p>
    <p>
        Nam quis est efficitur, varius enim vel, consectetur diam. Sed elit mauris, blandit a magna vel, semper rutrum mauris. Quisque mattis egestas luctus. Morbi fringilla, risus eget iaculis ultrices, leo erat pharetra dolor, nec ultrices purus massa vitae neque. In nisl lorem, aliquet a mattis placerat, consectetur at augue. Fusce ornare, justo sit amet tempus pretium, risus felis tempus risus, at laoreet ex leo id mi. Mauris elementum pellentesque erat, non lacinia velit lobortis consequat. In consequat velit ipsum, eget tempor lectus vestibulum rhoncus. Integer aliquam at elit eget convallis.
    </p>
    <p>
        Vivamus non justo dapibus, condimentum nunc quis, placerat diam. Mauris et ornare velit. Donec id fringilla diam. Morbi sagittis bibendum ornare. Sed sagittis, eros tempus pulvinar pulvinar, massa turpis pretium diam, nec eleifend orci erat ac magna. Nulla facilisis, sapien et congue vestibulum, nibh justo mollis sem, a bibendum ante eros id dolor. Phasellus rhoncus velit eget augue dapibus, eu ullamcorper odio ultrices. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
    </p>
    <p>
        Cras sit amet dolor et velit aliquet venenatis sit amet ut leo. Sed non tellus quis eros sagittis varius eget id lorem. Quisque ante odio, dapibus quis nunc laoreet, varius condimentum enim. Nam bibendum lectus ex, vel porttitor enim condimentum eu. Phasellus aliquet ipsum enim, ut fermentum est sagittis eget. Quisque ultricies pellentesque risus, eu laoreet neque pharetra sed. Cras eget mauris aliquet dolor laoreet feugiat.
    </p>
    <p>
        Fusce rhoncus malesuada lorem, et bibendum elit aliquet a. Quisque nec purus in nunc eleifend rhoncus. Etiam convallis iaculis malesuada. Duis ultrices eu velit faucibus sodales. Nam nunc nibh, pretium a nunc quis, ultricies aliquam augue. In hac habitasse platea dictumst. Cras elit sapien, aliquet sed hendrerit ac, tincidunt vitae mi. Proin non ex hendrerit, iaculis eros ac, efficitur nunc. Praesent porta mauris at lectus fermentum, ut sodales arcu vehicula. Donec sit amet facilisis enim. Donec facilisis tellus nec lacus luctus, non condimentum risus hendrerit. Nunc nisi dolor, maximus vel sollicitudin in, porttitor in nisl. Morbi vitae pharetra magna. Proin sed molestie ligula. Nulla egestas tempor nunc, in lobortis orci eleifend eu. Cras maximus posuere quam, porta tempus velit viverra ac.
    </p></div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="container">
        <p class="text-muted">Progetto finale del corso di Applicazioni internet. Polito (c) 2016</p>
    </div>
</div>

</body>
</html>