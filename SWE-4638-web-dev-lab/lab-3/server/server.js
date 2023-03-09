import express from 'express';
import cors from 'cors';
import morgan from 'morgan';
import connect from './connect.js';
// import router from './router/route.js';

import Book from './models/book.js'

const app = express();

/** middlewares */
app.use(express.json());
app.use(cors());
app.use(morgan('tiny'));
app.disable('x-powered-by'); // less hackers know about our stack


// const port = 8080;
const port = 8080;

app.get("/bookList",(req,res)=>{

})


app.post("/insert",async (req,res)=>{

  console.log(typeof req.body)

  const name = req.body.name
  const author = req.body.author
  const genre = req.body.genre

  const book = new Book({
    name,
    author,
    genre
  });

  console.log(book)
  // return save result as a response
  book.save()
      .then(result => res.status(201).send({ msg: "book Register Successfully"}))
      .catch(error => res.status(500).send({error}))

})

app.delete("/delete/:name",(req,res)=>{

  const name = req.params.name


})

app.put("/update",(req,res)=>{

  const name = req.body.name
  const author = req.body.author
  const genre = req.body.genre
 

})

/** start server only when we have valid connection */
connect().then(() => {
    try {
        app.listen(port, () => {
            console.log(`Server connected to http://localhost:${port}`);
        })
    } catch (error) {
        console.log('Cannot connect to the server')
    }
}).catch(error => {
    console.log(error);
})
