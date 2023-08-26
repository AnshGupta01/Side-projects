import { ADD_TODO, DELETE_TODO, UPDATE_TODO } from "../actions/action-types";

const initialState = [];

export default (state = initialState, action) => {
  switch (action.type) {
    case ADD_TODO:
      //Add todo
      //console.log(action.payload);
      return [...state, action.payload];
    case DELETE_TODO:
      //Delete the todo
      return state.filter((todo) => todo.id !== action.payload);
    case UPDATE_TODO:
      //update the todo
      return state.map((todo) => {
        if (todo.id === action.payload.todoId) {
          todo.title = action.payload.todo.title;
          todo.description = action.payload.todo.description;
          return todo;
        }
        return todo;
      });
    default:
      return state;
  }
};
