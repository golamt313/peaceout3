const express = require('express')
const app = express()
const TOKEN_SECRET="09f26e402586e2faa8da4c98a35f1b20d6b033c60"
const jwt = require('jsonwebtoken');

//import body-parser
var bodyParser = require('body-parser');
//configure body-parser for express
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

function generateAccessToken(login) {
  return jwt.sign(login,TOKEN_SECRET, { expiresIn: '1800s' });
}

function authenticateToken(req, res, next) {
  const token = req.headers['token']
  if (token == null) return res.sendStatus(401)
  jwt.verify(token, TOKEN_SECRET, (err, user) => {
    console.log(err)
    if (err) return res.sendStatus(403)
    req.user = user
    next()
  })
}


app.get('/',authenticateToken,function(req,res){
return res.sendStatus(200);
});

app.post('/api/auth/login', function (req, res) {
    console.log(req.body.username);
 resp = {
    username: "",
    password: "",
    token: generateAccessToken({ username: req.body.username })
 }
 console.log(resp);
  res.json(resp);
});


app.post('/api/auth/validate', function (req, res) {
    const token = req.body.jwtToken;
    console.log(token);
    if (token == null) {
        res.sendStatus = 401;
        return res.sendStatus(401)
    }
    try {
      decoded = jwt.verify(token, TOKEN_SECRET);
      console.log(decoded);
      res.sendStatus = 200;
      return res.json({status:200})
    }catch(e){
      console.log(e);
      res.sendStatus = 401;
      return res.json({status:401});
    }

})

app.listen(3000, console.log('App Listening to port 3000'));