const express = require('express')

const app = express()
const port = 3000

app.get('/json', (req, res) => {
  const generated = generateData();
  res.json(generated)
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
