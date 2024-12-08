import { useState } from 'react'
import './App.css'
import Button from 'react-bootstrap/Button';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Task from './utils/task';

const newTasks = [];
const inProgressTasks = [];
const completedTasks = [];

function App() {
  const [tname, setTname] = useState("");
  const [tdesc, setTdesc] = useState("");
  const [tpriority, setTpriority] = useState(-1);
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <>
      <nav>
          <p>My Task Manager</p>
          <Button variant="primary" onClick={handleOpen}>
            Add a new Task
          </Button>
      </nav>
      <Modal open={open} onClose={handleClose}>
        <Box id="modalStyle">
          <p>Please enter your task below</p>
          <input type='text' placeholder='Enter title of your task' onKeyUp={(event) =>{setTname(event.target.value);}}></input>
          <input type='text' placeholder='Enter description of your task' onKeyUp={(event) =>{setTdesc(event.target.value);}}></input>
          <div>
            <div>
                <label>Priority</label>
                <input type="radio" value="0" name="taskPriority" onChange={() => setTpriority(0)}></input>
                <label>High</label>
                <input type="radio" value="1" name="taskPriority" onChange={() => setTpriority(1)}></input>
                <label>Medium</label>
                <input type="radio" value="2" name="taskPriority" onChange={() => setTpriority(2)}></input>
                <label>Low</label>
            </div>
          </div>
          <div>
            <button>Save Task</button>
            <button onClick={handleClose}>Cancel</button>
          </div>
        </Box>
      </Modal>
      <div id="taskSection">
        <div className="taskCol">
          <p className="colHeading">New Task</p>
          <div className="taskItems">
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">In Progress</p>
          <div className="taskItems">
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
          </div>
        </div>
        <div className="taskCol">
          <p className="colHeading">Completed</p>
          <div className="taskItems">
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={1} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={0} />
            <Task title={"Title of the Task"} desc={"Description for the given task"} priority={2} />
          </div>
        </div>
      </div>
    </>
  )
}
export default App;
