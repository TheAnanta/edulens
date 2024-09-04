import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Checkbox from '@mui/material/Checkbox';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: "#448ccf",
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: "#E5E5E5",
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

function createData(
  name: string,
  regNo: string,
  attended: string,
  percentage: number,
  status: boolean,
) {
  return { name, regNo, attended, percentage, status };
}

const rows = [
  createData('John Doe', 'VU22CSEN0101001', '18/20', 90, true),
  createData('Jane Smith', 'VU22CSEN0101002', '19/20', 95, true),
  createData('Alice Johnson', 'VU22CSEN0101003', '17/20', 85, true),
  createData('Bob Brown', 'VU22CSEN0101004', '16/20', 80, false),
  createData('Charlie Davis', 'VU22CSEN0101005', '20/20', 100, true),
  createData('Daisy Evans', 'VU22CSEN0101006', '15/20', 75, false),
  createData('Evan Green', 'VU22CSEN0101007', '14/20', 70, false),
  createData('Fiona Harris', 'VU22CSEN0101008', '13/20', 65, true),
  createData('George Iverson', 'VU22CSEN0101009', '12/20', 60, false),
  createData('Hannah James', 'VU22CSEN0101010', '19/20', 95, true),
  createData('Isaac Kelly', 'VU22CSEN0101011', '11/20', 55, false),
  createData('Julia Lee', 'VU22CSEN0101012', '10/20', 50, false),
];

export default function CustomizedTables() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell align="left">Name</StyledTableCell>
            <StyledTableCell align="left">Reg No</StyledTableCell>
            <StyledTableCell align="left">Attended</StyledTableCell>
            <StyledTableCell align="left">Percentage</StyledTableCell>
            <StyledTableCell align="center">Mark Present</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.regNo}>
              <StyledTableCell component="th" scope="row">
                {row.name}
              </StyledTableCell>
              <StyledTableCell align="left">{row.regNo}</StyledTableCell>
              <StyledTableCell align="left">{row.attended}</StyledTableCell>
              <StyledTableCell align="left">{row.percentage}</StyledTableCell>
              <StyledTableCell align="left" className="flex justify-center items-center">
                <Checkbox checked={row.status} />
              </StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
