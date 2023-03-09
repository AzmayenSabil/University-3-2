import mongoose from "mongoose";

export const bookSchema = new mongoose.Schema({
  title: {
    type: String,
    required: true
  },
  author: {
    type: String,
    required: true
  },
  genre: {
    type: String,
    enum: ['Fiction', 'Novel', 'Non-fiction'],
    required: true
  },
  publishedDate: {
    type: Date,
    default: Date.now
  }
});


export default mongoose.model('Book', bookSchema);
