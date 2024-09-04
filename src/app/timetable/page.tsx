import Sidebar from '@/components/Sidebar';
import React from 'react';

function App() {
  const scheduleData = [
    { subjectCode: 'CSEN1001', subject: 'DBMS', section: 'A', roomNo: '501', timings: '10:00 - 11:00' },
    { subjectCode: 'CSEN1002', subject: 'Software Engineering', section: 'H', roomNo: '338', timings: '11:00 - 12:00' },
    { subjectCode: 'CSEN1003', subject: 'Algorithms', section: 'B', roomNo: '224', timings: '12:00 - 13:00' },
    { subjectCode: 'CSEN1004', subject: 'OS', section: 'I', roomNo: '608A', timings: '14:00 - 15:00' },
    { subjectCode: 'CSEN1005', subject: 'Computer Networks', section: 'H', roomNo: '501', timings: '15:00 - 16:00' },
    
  ];

  return (
    <div className="p-8 flex">
      <Sidebar />
      <div className="w-full overflow-hidden rounded-lg shadow-lg mt-24 space-y-10">
      <p className="w-full text-center text-4xl font-bold">TimeTable</p>
        <table className="w-full bg-[var(--main-color)] text-white">
          <thead>
            <tr>
              <th className="head">Subject Code</th>
              <th className="head">Subject</th>
              <th className="head">Section</th>
              <th className="head">Room No</th>
              <th className="head">Timings</th>
            </tr>
          </thead>
          <tbody>
            {scheduleData.map((item, index) => (
              <tr key={index} className="even:bg-[var(--secondary-color)] even:text-black odd:bg-[var(--main-color)]">
                <td>{item.subjectCode}</td>
                <td>{item.subject}</td>
                <td>{item.section}</td>
                <td>{item.roomNo}</td>
                <td>{item.timings}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
