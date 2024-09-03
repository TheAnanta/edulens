"use client";

import Sidebar from "@/components/Sidebar";
// import AvatarImage from "./avatar";
import { useState } from "react";
import MarkTable from "./MarkTable";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

export default function Page(props: { params: { id: string } }) {
  const [attendanceTopDetails, setAttendanceTopDetails] = useState([
    { Subject: "DBMS" },
    { CourseID: "007James" },
    { Section: "AB" },
    { Slot: "10:00 AM - 11:00 AM" },
  ]);

  return (
    <div className="flex ">
      <Sidebar />
      <div className="w-full flex-flex-col justify-center items-center space-y-4">
        <div className="w-full flex items-center justify-between space-x-8 pt-36 px-24">
          {attendanceTopDetails.map((item, index) => (
            <p
              key={index}
              className="text-base flex justify-center items-center gap-2"
            >
              <span className="">{Object.keys(item)[0]}:</span>
              <span className=" font-extrabold">{Object.values(item)[0]}</span>
            </p>
          ))}
        </div>
          <div className="w-[90%] mx-auto">
            <MarkTable/>
          </div>
      </div>
      <Stack spacing={2} direction="row">
      <Button variant="contained">Publish</Button>
      <Button variant="outlined">Cancel</Button>
    </Stack>
    </div>
  );
}
