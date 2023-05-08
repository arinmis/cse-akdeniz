const express = require('express')
const bodyParser = require('body-parser')

const app = express()
const port = 3000

// middlewares
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))


/* response n amount of value */ 
app.get('/json/:n', (req, res) => {
  data = {"values": []}
  const n = req.params.n;
  for (let i = 0; i < n; i++) { 
    data.values.push(generateData());
  }
  console.log('Data Received: ' + JSON.stringify(data));
  res.json(data)
})

app.listen(port, () => {
  console.log(`Node service is listening on port ${port}`)
})

/* generate random data object */ 
function generateData() { 
  return ({
    time: Date.now(),
    value: Math.random() * 100,
    available: Math.random() < 0.5
  })
}
