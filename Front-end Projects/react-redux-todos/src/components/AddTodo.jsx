import React, { useState } from "react";
import { Button, Card, Col, Container, Form, Row } from "react-bootstrap";
import DisplayCount from "./DisplayCount";
import { addTodo } from "../redux/actions/todo";
import { connect } from "react-redux";
import { v4 } from "uuid";

const AddTodo = ({ addTodo }) => {
  const [todo, setTodo] = useState({
    title: "",
    description: "",
    id: "",
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    //Add todo in store
    addTodo({ ...todo, id: v4() });
    console.log(todo);
    setTodo({
      title: "",
      description: "",
    });
  };

  return (
    <Container>
      <Row>
        <Col>
          <Card>
            <Card.Body>
              <h3>Add Todo Here</h3>
              <DisplayCount />
              {/*form*/}
              <Form onSubmit={handleSubmit}>
                {/*title*/}
                <Form.Group>
                  <Form.Label>Title</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter title"
                    value={todo.title}
                    onChange={(event) =>
                      setTodo({ ...todo, title: event.target.value })
                    }
                  />
                </Form.Group>
                {/*description*/}
                <Form.Group>
                  <Form.Label>Description</Form.Label>
                  <Form.Control
                    type={"textarea"}
                    placeholder="Enter here"
                    value={todo.description}
                    onChange={(event) =>
                      setTodo({ ...todo, description: event.target.value })
                    }
                  />
                </Form.Group>
                <Container className={"text-center mt-3"}>
                  <Button type={"submit"} variant={"primary"}>
                    Add Todo
                  </Button>
                </Container>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

const mapStateToProps = (state) => ({});

const mapDispatchToProps = (dispatch) => ({
  addTodo: (todo) => dispatch(addTodo(todo)),
});

export default connect(mapStateToProps, mapDispatchToProps)(AddTodo);
