import { useState } from 'react'
import './App.css'
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Task from './utils/task';
import { DragDropContext, Droppable, Draggable } from 'react-beautiful-dnd';

let TASK_ID = 0;

function App() {
  const [tname, setTname] = useState("");
  const [tdesc, setTdesc] = useState("");
  const [tpriority, setTpriority] = useState(-1);
  const [tasks, setTasks] = useState([]);
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const addTask = () => {
    if(tname === "" || tdesc === "" || tpriority == -1){
      alert("Enter proper task title,description,and priority");
      return;
    }
    tasks.push({
      taskId:TASK_ID,
      tname:tname,
      tdesc:tdesc,
      tpriority:tpriority,
      tstatus: 0
    });
    TASK_ID++;
    handleClose();
    setTname("");
    setTdesc("");
    setTpriority(-1);
    setTasks(tasks);
  }

  const deleteTask = (id) => {
    const newTasks = tasks.filter((task) => task.taskId !== id);
    setTasks(newTasks);
  }

  const updateTask = (updatedTask) => {
    const newTasks = tasks.map((task) => {
      if (task.taskId === updatedTask.taskId) {
        return { ...task, tname: updatedTask.title, tdesc: updatedTask.desc, tstatus: updatedTask.status, tpriority: updatedTask.priority };
      }
      return task;
    });
    setTasks(newTasks);
  }

  const handleDragEnd = (result) => {
    if (!result.destination || Number(result.source.droppableId) === 2) return;
    const updatedTasks = [...tasks];
    const [movedTask] = updatedTasks.splice(result.source.index, 1);
    movedTask.tstatus = Number(result.destination.droppableId);
    updatedTasks.splice(result.destination, 0, movedTask);
    setTasks(updatedTasks);
  };

  return (
    <>
      <DragDropContext onDragEnd={handleDragEnd}>
        <nav>
            <p>My Task Manager</p>
            <button variant="primary" onClick={handleOpen}>
              <span id="plusSym">+ </span> Add Task
            </button>
        </nav>
        <Modal open={open} onClose={handleClose}>
          <Box id="modalStyle">
            <p>Please enter your task below</p>
            <div className="inputs">
              <label>Title</label>
              <input type='text' placeholder='Enter title of your task' onKeyUp={(event) =>{setTname(event.target.value);}}></input>
              <label>Description</label>
              <input type='text' placeholder='Enter description of your task' onKeyUp={(event) =>{setTdesc(event.target.value);}}></input>
            </div>
            <div>
              <div>
                  <label>Priority:</label>
                  <span> </span>
                  <input type="radio" value="0" name="taskpriority" onChange={() => setTpriority(2)}></input>
                  <label>High</label>
                  <span> </span>
                  <input type="radio" value="1" name="taskpriority" onChange={() => setTpriority(1)}></input>
                  <label>Medium</label>
                  <span> </span>
                  <input type="radio" value="2" name="taskpriority" onChange={() => setTpriority(0)}></input>
                  <label>Low</label>
              </div>
            </div>
            <div>
              <button onClick={addTask}>Save Task</button>
              <span> </span>
              <button onClick={handleClose}>Cancel</button>
            </div>
          </Box>
        </Modal>
        <div id="taskSection">
          <div className="taskCol">
            <p className="colHeading">New Task</p>
            <Droppable droppableId='0'>
              {(provided) => (
                <div className="taskItems" ref={provided.innerRef} {...provided.droppableProps}>
                  {tasks
                    .filter((task) => task.tstatus === 0)
                    .map((task, index) => (
                      <Draggable key={task.taskId} draggableId={task.taskId.toString()} index={index}>
                        {(provided) => (
                          <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} >
                            <Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />
                          </div>
                        )}
                      </Draggable>
                    ))}
                  {provided.placeholder}
                </div>
              )}
            </Droppable>
          </div>
          <div className="taskCol">
            <p className="colHeading">In Progress</p>
              <Droppable droppableId='1'>
              {(provided) => (
                <div className="taskItems" ref={provided.innerRef} {...provided.droppableProps}>
                  {tasks
                    .filter((task) => task.tstatus === 1)
                    .map((task, index) => (
                      <Draggable key={task.taskId} draggableId={task.taskId.toString()} index={index}>
                        {(provided) => (
                          <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} >
                            <Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />
                          </div>
                        )}
                      </Draggable>
                    ))}
                  {provided.placeholder}
                </div>
              )}
              </Droppable>
          </div>
          <div className="taskCol">
            <p className="colHeading">Completed</p>
              <Droppable droppableId='2'>
              {(provided) => (
                <div className="taskItems" ref={provided.innerRef} {...provided.droppableProps}>
                  {tasks
                    .filter((task) => task.tstatus === 2)
                    .map((task, index) => (
                      <Draggable key={task.taskId} draggableId={task.taskId.toString()} index={index}>
                        {(provided) => (
                          <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} >
                            <Task id={task.taskId} title={task.tname} desc={task.tdesc} priority={task.tpriority} status={task.tstatus} updateTask={updateTask} deleteTask={deleteTask} />
                          </div>
                        )}
                      </Draggable>
                    ))}
                  {provided.placeholder}
                </div>
              )}
            </Droppable>
          </div>
        </div>
      </DragDropContext>
    </>
  )
}
export default App;
