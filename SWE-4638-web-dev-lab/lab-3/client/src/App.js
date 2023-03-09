import { useState, useEffect } from "react";
import axios from "axios";
import './App.css'

function BookForm() {
    const [name, setName] = useState('');
    const [author, setAuthor] = useState('');
    const [genre, setGenre] = useState('');
    const [errors, setErrors] = useState({});

    const [newBook, setNewBook] = useState({ title: '', author: '', genre: '' });
    const [selectedBook, setSelectedBook] = useState(null);

    const dummyData = [
      { id: 1, title: 'To Kill a Mockingbird', author: 'Harper Lee', genre: 'Fiction' },
      { id: 2, title: 'The Catcher in the Rye', author: 'J.D. Salinger', genre: 'Novel' },
      { id: 3, title: '1984', author: 'George Orwell', genre: 'Fiction' },
      { id: 4, title: 'Pride and Prejudice', author: 'Jane Austen', genre: 'Novel' },
      { id: 5, title: 'The Great Gatsby', author: 'F. Scott Fitzgerald', genre: 'Novel' },
    ];

    const [books, setBooks] = useState(dummyData);

    // define error messages for each input
    const errorMessages = {
      name: 'Please enter a valid name',
      author: 'Please enter first and last names',
      genre: 'Please select a genre'
    };
    
    // define a function to validate the form inputs
    const validateInputs = () => {
      let errors = {};
      // validate name
      if (!/^[a-zA-Z ]+$/.test(name)) {
        errors.name = errorMessages.name;
      }
      // validate author
      const authorNameArray = author.split(' ');
      if (authorNameArray.length < 2) {
        errors.author = errorMessages.author;
      }
      // validate genre
      if (!['Fiction', 'Novel', 'Non-fiction'].includes(genre)) {
        errors.genre = errorMessages.genre;
      }
      setErrors(errors);
      return Object.keys(errors).length === 0;
    };
    
    // define a function to handle form submission
    const handleSubmit = (event) => {
      event.preventDefault();
      if (validateInputs()) {
        console.log('Form submitted successfully')
        // call an API or other function to submit the form data
        setNewBook({name, author, genre})
        console.log(newBook)
        
        
        axios.post('http://localhost:8080/insert', JSON.stringify(newBook))
        .then((response) => {
          setBooks([...books, response.data]);
          setNewBook({ title: '', author: '', genre: '' });
        })
        .catch((error) => console.log(error));
      } else {
        console.log('Form validation errors:', errors);
      }

    };

  // useEffect(() => {
  //   axios.get('')
  //     .then((response) => setBooks(response.data))
  //     .catch((error) => console.log(error));
  // }, []);

  // const handleDelete = (id) => {
  //   axios.delete(`/api/books/${id}`)
  //     .then(() => {
  //       const updatedBooks = books.filter((book) => book._id !== id);
  //       setBooks(updatedBooks);
  //     })
  //     .catch((error) => console.log(error));
  // };

  // const handleUpdate = () => {
  //   axios.put(`/api/books/${selectedBook._id}`, selectedBook)
  //     .then(() => {
  //       const updatedBooks = books.map((book) => {
  //         if (book._id === selectedBook._id) {
  //           return selectedBook;
  //         }
  //         return book;
  //       });
  //       setBooks(updatedBooks);
  //       setSelectedBook(null);
  //     })
  //     .catch((error) => console.log(error));
  // };

  // const handleSelect = (book) => {
  //   setSelectedBook(book);
  //   setNewBook(book);
  // };

    
    return (
      <div>
        <form onSubmit={handleSubmit}>
          <label>
            Name:
            <input
              type="text"
              value={name}
              onChange={(event) => setName(event.target.value)}
            />
            {errors.name && <div className="error">{errors.name}</div>}
          </label>
          <br></br>
          <label>
            Author:
            <input
              type="text"
              value={author}
              onChange={(event) => setAuthor(event.target.value)}
            />
            {errors.author && <div className="error">{errors.author}</div>}
          </label>
          <br></br>
          <label>
            Genre:
            <select value={genre} onChange={(event) => setGenre(event.target.value)}>
              <option value="">Select a genre</option>
              <option value="Fiction">Fiction</option>
              <option value="Novel">Novel</option>
              <option value="Non-fiction">Non-fiction</option>
            </select>
            {errors.genre && <div className="error">{errors.genre}</div>}
          </label>
          <button type="submit">Submit</button>
        </form>
        <br></br>
        <br></br>
        <table>
        <thead>
          <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr key={book.id}>
              <td>{book.title}</td>
              <td>{book.author}</td>
              <td>{book.genre}</td>
              <td>
                {/* <button onClick={() => handleDelete(book.id)}>Delete</button> */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    );
  }
  
  export default BookForm;
  